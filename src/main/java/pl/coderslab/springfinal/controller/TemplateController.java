package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.service.TemplateService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/template")
public class TemplateController {

    private TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping()
//    @Transactional
    public String allTemplates(Model model) {
        List<Template> templateList = this.templateService.findAll();
        model.addAttribute("templates", templateList);
        return "templates/list";
    }

//    @ModelAttribute("templates")
//    public List<Template> templateList() {
//        return templateService.findAll();
//    }

    @GetMapping("/add")
    public String addTemplate(Model model) {
        Template template = new Template();
        model.addAttribute("template", template);
        return "templates/form";
    }

    @PostMapping("/save")
    public String saveTemplate(Template template) {
        templateService.save(template);
        return "redirect:/template";
    }
//    @PostMapping("/save")
//    public String saveBook(@Valid Book book, BindingResult validation){
//        if(validation.hasErrors()){
//            return "book/form";
//        }
//
//        bookService.save(book);
//        return "redirect:/book";
//    }

    @GetMapping("/edit/{id}")
    public String templateEdit(@PathVariable long id, Model model){
        Template template = templateService.findOneByIdWithAllData(id);
        model.addAttribute("template", template);
        return "templates/form";
    }

    @GetMapping("/{id}")
    public String templateDetails(@PathVariable long id, Model model){
        Template template = templateService.findOneByIdWithAllData(id);
        model.addAttribute("template", template);
        return "templates/details";
    }

    @GetMapping("/delete/{id}")
    public String deleteTemplateConfirm(@PathVariable long id, Model model){
        Template template = templateService.findOneByIdWithAllData(id);
        model.addAttribute("template", template);
        model.addAttribute("delete", true);
        return "templates/details";
    }
    @PostMapping("/delete/{id}")
    public String deleteTemplate(@PathVariable long id, Model model) {
        Template template = templateService.findOneById(id);
        templateService.delete(template);
        return "redirect:/template?del=" + template.getName();
    }
}
