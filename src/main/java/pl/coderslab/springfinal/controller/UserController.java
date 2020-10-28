package pl.coderslab.springfinal.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.service.CurrentUser;
import pl.coderslab.springfinal.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
    public String accountDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
//        User user = this.userService.findOneById(1L);
//        if(user.getRole().equals("banned")) model.addAttribute("isDisabled", "true");
        if(currentUser.isEnabled()) model.addAttribute("isDisabled", "true");
        model.addAttribute("user", currentUser.getUser());
        return "user/form";
    }

    @PostMapping("/save")
    public String saveAccountData(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        User originalUser = this.userService.findOneById(user.getId());
//        user.setId(originalUser.getId());
//        user.setRole(originalUser.getRole());
        user.setRegisteredOn(originalUser.getRegisteredOn());
        this.userService.save(user);
        model.addAttribute("result", "Data saved successfully!");
        return "user/form";
    }
}
