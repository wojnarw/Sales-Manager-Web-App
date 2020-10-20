package pl.coderslab.springfinal.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.UserService;

import javax.xml.transform.Templates;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class UserFixture {
    private UserService userService;
    private TemplateService templateService;
    private Faker faker;

    @Autowired
    public UserFixture(
            UserService userService,
            TemplateService templateService
    ) {
        this.userService = userService;
        this.templateService = templateService;
        this.faker = new Faker();
    }

    public void createDataInDb() {
        Random random = new Random();
        String[] emailDomains = {
                "gmail.com",
                "yahoo.com",
                "bing.com",
                "aol.com",
                "outlook.com",
                "mail.com"
        };
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            int choice = random.nextInt(emailDomains.length);
            user.setEmail(faker.name().username() + "@" + emailDomains[choice]);
            user.setPassword("12345");

//            List<Template> templates = new ArrayList<>();
//            int numOfTemplates = random.nextInt(3) + 1;
//            for (int j = 0; j <numOfTemplates; j++) {
//                Template randomTemplate = this.templateService.findOneById((long) random.nextInt(10));
//                templates.add(randomTemplate);
//            }
//            user.setTemplates(templates);

            this.userService.save(user);
        }
    }
}
