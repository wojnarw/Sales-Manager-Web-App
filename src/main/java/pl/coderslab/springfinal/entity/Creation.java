package pl.coderslab.springfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "creations")
public class Creation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    private String description;

    @Column(columnDefinition = "DATETIME")
    private String createdAt;

    @Column(columnDefinition = "DATETIME")
    private String updatedAt;

//    @Column(columnDefinition = "TEXT")
    @Transient
    private HashMap<String, String> fieldList;

//    @Column(columnDefinition = "TEXT")
//    private String content;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "creation")
    List<InputFields> inputFields;

    @ManyToMany
    List<Template> templates = new ArrayList<>();

    @Override
    public String toString() {
        return "Creation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
//                ", jsonFields='" + jsonFields + '\'' +
//                ", content='" + content + '\'' +
//                ", user=" + user +
//                ", inputFields=" + inputFields +
//                ", templates=" + templates +
                '}';
    }
}
