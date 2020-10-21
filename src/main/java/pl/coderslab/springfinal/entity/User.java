package pl.coderslab.springfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Size(min = 3, max = 255)
    @NotNull
    private String username;
    @NotNull
    private String password;

//    @Size(min = 5, max = 255)
    @NotNull
    @Email
    private String email;

    @Column(columnDefinition = "DATETIME")
    private String registeredOn;

    @NotNull
    private String role;

    @OneToMany(mappedBy = "user")
    List<Template> templates = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    List<Publication> publications = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
