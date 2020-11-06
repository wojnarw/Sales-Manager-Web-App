package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.InputFields;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.service.CreationService;
import pl.coderslab.springfinal.service.CurrentUser;
import pl.coderslab.springfinal.service.TemplateService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/app/creations")
public class CreationController {

    private CreationService creationService;
    private TemplateService templateService;

    @Autowired
    public CreationController(CreationService creationService, TemplateService templateService) {
        this.creationService = creationService;
        this.templateService = templateService;
    }

    @GetMapping()
    public String showMyCreations(
            Model model,
            @RequestParam(name="p", defaultValue = "0") Integer page,
            @RequestParam(name="s", defaultValue = "20") Integer size,
            @RequestParam(name="sort", defaultValue = "id") String sortBy,
            @AuthenticationPrincipal CurrentUser currentUser) {

        //page, size, sortBy

        List<Creation> creations = this.creationService.findAllByUser(currentUser.getUser());//, page, size);
        model.addAttribute("creations", creations);
        return "creation/list";
    }

    @GetMapping("/add")
    public String addCreation(Model model) {
        Creation creation = new Creation();
        model.addAttribute("creation", creation);
        return "creation/form";
    }

    @PostMapping("/save")
    public String saveCreation(Creation creation, @AuthenticationPrincipal CurrentUser currentUser) {
        Long id = creation.getId();
        //if creation already exists (edit it)
        if(id != null) {
            Creation originalCreation = this.creationService.findOneByIdAndUser(id, currentUser.getUser());
            creation.setCreatedAt(originalCreation.getCreatedAt());
            creation.setUser(currentUser.getUser());
        }
        creation.setCreatedAt(creation.getUpdatedAt());
//        creationService.save(creation);
        return "redirect:/app/creations";

//        creationService.save(creation);
//        return "creation/form";// "redirect:/app/creation";
    }

    @GetMapping("/edit/{id}")
    public String creationEdit(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser){
        Creation creation = creationService.findOneByIdAndUser(id, currentUser.getUser());
        if(creation == null) return "errors/404";
        model.addAttribute("creation", creation);
        List<InputFields> inputFields = creation.getInputFields();
        model.addAttribute("inputFields", inputFields);
        return "creation/form";
    }

    @GetMapping("/{id}")
    public String creationDetails(@PathVariable Long id, Model model, @AuthenticationPrincipal CurrentUser currentUser){
        Creation creation = this.creationService.findOneByIdAndUser(id, currentUser.getUser());
        if(creation == null) return "errors/404";
//        String jsonFields = creation.getJsonFields();
//        HashMap<String, String> fields = new HashMap<>();
//        if(jsonFields != null) {
//            fields = (HashMap<String, String>) Arrays.asList(jsonFields.split(",")).stream().map(s -> s.split(":")).collect(Collectors.toMap(e -> e[0], e -> e[1]));
//        }
//        model.addAttribute("fields", fields);
        model.addAttribute("creation", creation);
        return "creation/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCreationConfirm(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser){
        Creation creation = creationService.findOneByIdAndUser(id, currentUser.getUser());
        if(creation == null) return "errors/404";
        model.addAttribute("creation", creation);
        model.addAttribute("delete", true);
        return "creation/details";
    }
    @PostMapping("/delete/{id}")
    public String deleteCreation(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        Creation creation = creationService.findOneByIdAndUser(id, currentUser.getUser());
        if(creation == null) return "errors/404";
        creationService.delete(creation);
        return "redirect:/app/creation?del=" + creation.getName();
    }

    @ModelAttribute("allTemplates")
    public List<Template> templateList(@AuthenticationPrincipal CurrentUser currentUser) {
        Page<Template> templatePage = this.templateService.findAllWithThisUser(currentUser.getUser(), 0, Integer.MAX_VALUE, "updatedAt");
        List<Template> templates = templatePage.getContent();
        return templates;
    }

    @ModelAttribute("userName")
    public String userName(@AuthenticationPrincipal CurrentUser currentUser) {
        return currentUser.getUser().getUsername();
    }

    @ModelAttribute("title")
    public String title() {
        return "Creations";
    }

    @ModelAttribute("isAdmin")
    public Boolean isAdmin(@AuthenticationPrincipal CurrentUser currentUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //has role ADMIN?
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"));
    }
}
