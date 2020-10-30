package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.service.CurrentUser;
import pl.coderslab.springfinal.service.TemplateService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/templates")
public class TemplateController {
    private TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping()
    public String myTemplates(
            Model model,
            @RequestParam(name="p", defaultValue = "0") Integer page,
            @RequestParam(name="s", defaultValue = "1000") Integer size,
            @RequestParam(name="sort", defaultValue = "updatedAt") String sortBy,
            @AuthenticationPrincipal CurrentUser currentUser) {
        Page<Template> templatePage = templateService.findAllWithThisUser(currentUser.getUser(), page, size, sortBy);
        List<Template> templateList = templatePage.getContent();
        model.addAttribute("templates", templateList);
        model.addAttribute("numOfTemplates", templatePage.getTotalElements());
        model.addAttribute("numOfPages", templatePage.getTotalPages());
        model.addAttribute("page", page);
        return "templates/list";
    }

    @GetMapping("/add")
    public String addTemplate(Model model) {
        Template template = new Template();
        model.addAttribute("template", template);
        return "templates/form";
    }

    @PostMapping("/save")
    public String saveTemplate(@Valid Template template, BindingResult validation, @AuthenticationPrincipal CurrentUser currentUser) {
        if(validation.hasErrors()){
            return "templates/form";
        }
        Long id = template.getId();
        //if template already exists (edit it)
        if(id != null) {
            Template originalTemplate = this.templateService.findOneById(id);
            template.setCreatedAt(originalTemplate.getCreatedAt());
        }
        else {
            template.setCreatedAt(template.getUpdatedAt());
        }
        template.setUser(currentUser.getUser());
        templateService.save(template);
        return "redirect:/app/templates";
    }

    @GetMapping("/edit/{id}")
    public String templateEdit(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser){
        Template template = templateService.findOneByIdAndUser(id, currentUser.getUser());
        if(template == null) return "errors/404";
        model.addAttribute("template", template);
        return "templates/form";
    }

    @GetMapping("/{id}")
    public String templateDetails(@PathVariable long id, Model model){
        Template template = templateService.findOneByIdWithAllData(id);
        if(template == null) return "errors/404";
        model.addAttribute("template", template);
        return "templates/details";
    }

    @GetMapping("/delete/{id}")
    public String deleteTemplateConfirm(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser){
        Template template = templateService.findOneByIdAndUser(id, currentUser.getUser());
        if(template == null) return "errors/404";
        model.addAttribute("template", template);
        model.addAttribute("delete", true);
        return "templates/details";
    }
    @PostMapping("/delete/{id}")
    public String deleteTemplate(@PathVariable long id, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        Template template = templateService.findOneByIdAndUser(id, currentUser.getUser());
        if(template == null) return "errors/404";
        templateService.delete(template);
        return "redirect:/app/templates?del=" + template.getName();
    }

    @ModelAttribute("userName")
    public String userName(@AuthenticationPrincipal CurrentUser currentUser) {
        return currentUser.getUser().getUsername();
    }

    @ModelAttribute("title")
    public String title() {
        return "Templates";
    }

    @ModelAttribute("isAdmin")
    public Boolean isAdmin(@AuthenticationPrincipal CurrentUser currentUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //has role ADMIN?
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"));
    }
}
