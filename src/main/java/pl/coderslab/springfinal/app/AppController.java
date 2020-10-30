package pl.coderslab.springfinal.app;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Role;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.repository.RoleRepository;
import pl.coderslab.springfinal.service.CreationService;
import pl.coderslab.springfinal.service.CurrentUser;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/app")
public class AppController {
    private UserService userService;
    private TemplateService templateService;
    private CreationService creationService;
    private RoleRepository roleRepository;

    @Autowired
    public AppController(
            UserService userService,
            TemplateService templateService,
            CreationService creationService,
            RoleRepository roleRepository
    ) {
        this.userService = userService;
        this.templateService = templateService;
        this.creationService = creationService;
        this.roleRepository = roleRepository;
    }

    @GetMapping()
    public String userLanding(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        List<Template> lastFiveTemplates = this.templateService.getLastFive(currentUser.getUser());
        List<Creation> lastFiveCreations = this.creationService.getLastFive(currentUser.getUser());
        model.addAttribute("lastFiveTemplates", lastFiveTemplates);
        model.addAttribute("lastFiveCreations", lastFiveCreations);
        return "app";
    }

    @ModelAttribute("userName")
    public String userName(@AuthenticationPrincipal CurrentUser currentUser) {
        return currentUser.getUser().getUsername();
    }

    @ModelAttribute("title")
    public String title() {
        return "Dashboard";
    }

    @ModelAttribute("isAdmin")
    public Boolean isAdmin(@AuthenticationPrincipal CurrentUser currentUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //has role ADMIN?
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"));
    }
}
