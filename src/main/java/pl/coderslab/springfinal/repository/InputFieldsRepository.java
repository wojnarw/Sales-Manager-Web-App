package pl.coderslab.springfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.InputFields;

import java.util.List;

public interface InputFieldsRepository extends JpaRepository<InputFields, Long> {
    InputFields findOneByCreation(Creation creation);
    List<InputFields> findAllByCreation(Creation creation);
}
