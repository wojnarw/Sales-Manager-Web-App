package pl.coderslab.springfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "input_fields")
@ToString
public class InputFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String value;

    @ManyToOne
    private Creation creation;
}
