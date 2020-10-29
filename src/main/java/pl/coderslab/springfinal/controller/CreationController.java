package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("")
    public String showMyCreations(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Creation> creations = creationService.findAllByUser(currentUser.getUser());
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
    public String deleteCreationConfirm(@PathVariable long id, Model model){
        Creation creation = creationService.findOneByIdWithAllData(id);
        model.addAttribute("creation", creation);
        model.addAttribute("delete", true);
        return "creation/details";
    }
    @PostMapping("/delete/{id}")
    public String deleteCreation(@PathVariable long id, Model model) {
        Creation creation = creationService.findOneById(id);
        creationService.delete(creation);
        return "redirect:/app/creation?del=" + creation.getName();
    }

//TODO zmienic na templatki danego uzytkownika
    @ModelAttribute("allTemplates")
    public List<Template> templateList() {
        List<Template> templates = this.templateService.findAll();
        return templates;
    }
}
