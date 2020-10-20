package pl.coderslab.springfinal.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class TemplateFixture {
    private TemplateService templateService;
    private UserService userService;
    private Faker faker;

    @Autowired
    public TemplateFixture(
            TemplateService templateService
            ,UserService userService
    ) {
        this.templateService = templateService;
        this.userService = userService;
        this.faker = new Faker();
    }

    public void createDataInDb() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Template template = new Template();
            template.setName(faker.commerce().productName());
            template.setContent(faker.lorem().fixedString(1000));
//            String fakeDateTime = faker.date().past(1, TimeUnit.DAYS).toString();
            int year = random.nextInt(5) + 2015;
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(31) + 1;
            int hour = random.nextInt(23);
            int minute = random.nextInt(60);
            int second = random.nextInt(60);
            String fakeDateTime = String.format("%d-%d-%d %d:%d:%d", year,month,day,hour,minute,second);
            template.setCreatedAt(fakeDateTime);
            template.setUpdatedAt(fakeDateTime);

            User randomUser = this.userService.findOneById((long) random.nextInt(5)+1);
            template.setUser(randomUser);

            this.templateService.save(template);
        }
    }
}
