package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private TemplateService templateService;
//    private PublicationService publicationService;

    @Autowired
    public AdminController(UserService userService, TemplateService templateService) {
        this.userService = userService;
        this.templateService = templateService;
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
    public String toggleBan(@PathVariable long id) {
        User user = this.userService.findOneById(id);
        if(user.getRole().equals("user")) user.setRole("banned");
        else user.setRole("user");
        this.userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable long id, Model model) {
        User user = this.userService.findOneById(id);
        model.addAttribute("user", user);
        int numOfTemplates = this.templateService.countAllByUserId(id);
        model.addAttribute("numOfTemplates", numOfTemplates);
        return "admin/user/details";
    }

//    @ModelAttribute("users")
//    public String userList() {
//        List<User> users = this.userService.findAllWithAllData();
//    }
}
