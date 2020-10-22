package pl.coderslab.springfinal.app;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/app")
public class AppController {
    private UserService userService;
    private TemplateService templateService;

    @Autowired
    public AppController(UserService userService, TemplateService templateService) {
        this.userService = userService;
        this.templateService = templateService;
    }

    @GetMapping()
    public String userLanding(Model model) {
        Set<Template> lastFiveTemplates = this.templateService.getLastFive();
        model.addAttribute("lastFiveTemplates", lastFiveTemplates);
        return "app";
    }
}
