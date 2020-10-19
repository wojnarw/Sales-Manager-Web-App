package pl.coderslab.springfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Column(columnDefinition = "TEXT")
    private String templateText;

    @ManyToOne
    User user;

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", templateText='" + templateText + '\'' +
                '}';
    }
}
