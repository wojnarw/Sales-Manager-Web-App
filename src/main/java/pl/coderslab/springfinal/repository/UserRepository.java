package pl.coderslab.springfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.entity.Template;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Query("select u from User u left join fetch u.templates t where u.id = :id") //  join fetch u.publications p")
    User findOneByIdWithAllData(@Param("id") Long id);

//    List<User> findAllByTemplateName(String name);

}
