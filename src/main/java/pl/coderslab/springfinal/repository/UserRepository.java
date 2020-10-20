package pl.coderslab.springfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.entity.Template;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

//    User findUserById(Long id);
//    List<User> findAllByTemplateName(String name);

}
