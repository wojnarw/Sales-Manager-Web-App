package pl.coderslab.springfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springfinal.fixture.TemplateFixture;
import pl.coderslab.springfinal.fixture.UserFixture;

@Controller
@RequestMapping("/fixtures")
public class FixtureController {
    private UserFixture userFixture;
    private TemplateFixture templateFixture;

    @Autowired
    public FixtureController(TemplateFixture templateFixture, UserFixture userFixture) {
        this.userFixture = userFixture;
        this.templateFixture = templateFixture;
    }

    @GetMapping
    public String loadDataToDb() {
        userFixture.createDataInDb();
        templateFixture.createDataInDb();
        return "redirect:/template";
    }
}
