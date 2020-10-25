package pl.coderslab.springfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "templates")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 255)
    @NotNull
    private String name;

    @Column(columnDefinition = "DATETIME")
    private String createdAt;
    @Column(columnDefinition = "DATETIME")
    private String updatedAt;

    private String description;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    User user;

    @ManyToMany(mappedBy = "templates")
    List<Creation> creations = new ArrayList<>();

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", templateText='" + content + '\'' +
                '}';
    }
}
