package pl.coderslab.springfinal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
