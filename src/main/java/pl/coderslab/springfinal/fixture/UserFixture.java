package pl.coderslab.springfinal.fixture;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import pl.coderslab.springfinal.entity.Role;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.service.TemplateService;
import pl.coderslab.springfinal.service.UserService;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
        //user to log in
        User user1 = new User();
        user1.setUsername("user");
//        String salt = BCrypt.gensalt();
        user1.setPassword("12345");//(BCrypt.hashpw("12345",salt));
        user1.setRole("user");
        user1.setEmail("a@a.pl");
//        user1.setEnabled(true);
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role();
//        role.setName("ROLE_USER");
//        roles.add(role);
//        user1.setRoles(roles);
        userService.save(user1);

        User admin = new User();
        admin.setUsername("admin");
//        salt = BCrypt.gensalt();
        admin.setPassword("12345");//(BCrypt.hashpw("12345",salt));
        admin.setRole("admin");
        admin.setEmail("a2@a.pl");
//        admin.setEnabled(true);
//        Set<Role> roles2 = new HashSet<>();
//        Role role2 = new Role();
//        role2.setName("ROLE_ADMIN");
//        roles2.add(role2);
//        admin.setRoles(roles2);
        userService.save(admin);

        Random random = new Random();
        String[] emailDomains = {
                "gmail.com",
                "yahoo.com",
                "bing.com",
                "aol.com",
                "outlook.com",
                "mail.com"
        };
        int year = 2015;
        for (int i = 0; i < 5; i++) {
            User user = new User();
            String username = faker.name().username();
            user.setUsername(username);
            int choice = random.nextInt(emailDomains.length);
            user.setEmail(username + "@" + emailDomains[choice]);
            user.setPassword("12345");
//            user.setEnabled(true);
//            int year = random.nextInt(5) + 2015;
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(27) + 1;
            int hour = random.nextInt(23);
            int minute = random.nextInt(60);
            int second = random.nextInt(60);
            String fakeDateTime = String.format("%d-%d-%d %d:%d:%d", year,month,day,hour,minute,second);
            user.setRegisteredOn(fakeDateTime);
            year++;

            int chance = random.nextInt(4);
            if(chance > 0) user.setRole("user");
            else user.setRole("banned");

//            roles = new HashSet<>();
//            role = new Role();
//            role.setName("ROLE_USER");
//            roles.add(role);
//            user.setRoles(roles);

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
