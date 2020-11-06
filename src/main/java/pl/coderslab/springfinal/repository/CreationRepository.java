package pl.coderslab.springfinal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;

import java.util.List;
import java.util.Set;

@Repository
public interface CreationRepository extends JpaRepository<Creation,Long> {
    Creation findByName(String name);
    @Query("select c from Creation c join fetch c.user u") //  join fetch t.publications p")
    Set<Creation> findAllWithAllData();
    @Query("select c from Creation c left join fetch c.user left join fetch c.inputFields where c.id = :id") //  join fetch t.publications p")
    Creation findOneByIdWithAllData(@Param("id") Long id);
    int countAllByUserId(Long id);
    //List<Creation> findAllWithThisTemplate(Template template);

    Creation findOneByIdAndUser(Long id, User user);
    Page<Creation> findAllByUser(User user, Pageable pageable);
    List<Creation> findAllByUser(User user);

}
