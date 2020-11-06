package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.service.CreationService;
import pl.coderslab.springfinal.service.CurrentUser;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private TemplateService templateService;
    private CreationService creationService;

    @Autowired
    public AdminController(UserService userService, TemplateService templateService, CreationService creationService) {
        this.userService = userService;
        this.templateService = templateService;
        this.creationService = creationService;
    }

    @GetMapping()
    public String adminLanding(Model model) {
        Set<User> lastFiveUsers = this.userService.getLastFive();
        model.addAttribute("lastFiveUsers", lastFiveUsers);
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String userList(@RequestParam(required=false, defaultValue = "") String sort, Model model) {
        if(sort.isEmpty()) sort = "idDesc";
        List<User> users = this.userService.getAll(sort);
        model.addAttribute("users", users);
        return "admin/user/list";
    }

    @GetMapping("/user/ban/{id}")
    @Transactional
    public String toggleBan(@PathVariable long id) {
        this.userService.userToggleBan(id);
        return "redirect:/admin/user/" + id;
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable long id, Model model) {
        User user = this.userService.findOneById(id);
        model.addAttribute("user", user);
        int numOfTemplates = this.templateService.countAllByUserId(id);
        model.addAttribute("numOfTemplates", numOfTemplates);
        int numOfCreations = this.creationService.countAllByUserId(id);
        model.addAttribute("numOfCreations", numOfCreations);
        return "admin/user/details";
    }

    @ModelAttribute("userName")
    public String userName(@AuthenticationPrincipal CurrentUser currentUser) {
        return currentUser.getUser().getUsername();
    }

    @ModelAttribute("title")
    public String title() {
        return "Admin panel";
    }

    @ModelAttribute("isAdmin")
    public Boolean isAdmin(@AuthenticationPrincipal CurrentUser currentUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //has role ADMIN?
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"));
    }
}
