package pl.coderslab.springfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorsController {

    @GetMapping("/404")
    public String badAddress() {
        return "errors/404";
    }
    @GetMapping("/403")
    public String unauthorized() {
        return "errors/403";
    }
    @GetMapping("/500")
    public String serverError() {
        return "errors/500";
    }
}
