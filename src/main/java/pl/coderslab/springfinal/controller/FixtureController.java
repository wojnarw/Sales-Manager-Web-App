package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springfinal.fixture.TemplateFixture;

@Controller
@RequestMapping("/fixtures")
public class FixtureController {
    private TemplateFixture templateFixture;

    @Autowired
    public FixtureController(TemplateFixture templateFixture) {
        this.templateFixture = templateFixture;
    }

    @GetMapping
    public String loadDataToDb() {
        templateFixture.createDataInDb();
        return "redirect:/template";
    }
}
