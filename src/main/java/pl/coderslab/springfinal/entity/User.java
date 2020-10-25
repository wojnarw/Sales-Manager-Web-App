package pl.coderslab.springfinal.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Size(min = 3, max = 255)
    @NotEmpty(message = "*Please provide a user name")
    @Length(min = 3, message = "*Your user name must have at least 3 characters")
    private String username;

    @NotEmpty(message = "*Please provide your password")
    @Length(min = 7, message = "*Your password must have at least 7 characters")
    private String password;

    @NotEmpty(message = "*Please provide an email")
    @Email(message = "*Please provide a valid Email")
    private String email;

    private Boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    private Boolean active;
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles;


    @Column(columnDefinition = "DATETIME")
    private String registeredOn;

//    @NotNull
    private String role;

    @OneToMany(mappedBy = "user")
    List<Template> templates = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    List<Creation> creations = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
