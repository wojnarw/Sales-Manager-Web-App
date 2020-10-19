package pl.coderslab.springfinal.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.service.TemplateService;

import java.util.Random;

@Component
public class TemplateFixture {
    private TemplateService templateService;
    private Faker faker;

    @Autowired
    public TemplateFixture(TemplateService templateService) {
        this.templateService = templateService;
        this.faker = new Faker();
    }

    public void createDataInDb() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Template template = new Template();
            template.setName(faker.commerce().productName());
            template.setContent(faker.lorem().fixedString(1000));
            templateService.save(template);
        }
    }
}
