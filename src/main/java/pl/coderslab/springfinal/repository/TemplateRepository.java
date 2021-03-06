package pl.coderslab.springfinal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;

import java.util.List;
import java.util.Set;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
    Template findByName(String name);
    @Query("select t from Template t join fetch t.user u") //  join fetch t.publications p")
    Set<Template> findAllWithAllData();
    @Query("select t from Template t left join fetch t.user u where t.id = :id") //  join fetch t.publications p")
    Template findOneByIdWithAllData(@Param("id") Long id);
    int countAllByUserId(long id);

    Template findOneByIdAndUser(Long id, User user);
    Page<Template> findAllByUser(User user, Pageable pageable);

}
