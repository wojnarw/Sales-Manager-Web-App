package pl.coderslab.springfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.entity.Template;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Query("select u from User u left join fetch u.templates t where u.id = ?1") //  join fetch u.publications p")
    User findOneByIdWithAllData(Long id);
    @Query("select u from User u left join fetch u.templates t order by u.id asc") //  join fetch t.publications p")
    Set<User> findAllWithAllData();
    @Query("select u from User u order by u.id desc")
    Set<User> getLast();
    @Query(value = "SELECT * FROM users ORDER BY users.id DESC LIMIT 5",
            nativeQuery = true)
    Set<User> getLastFive();






//    Set<User> findByOrderByUsernameAsc();
//
//    @Query("select u from User u order by u.id asc")
//    Set<User> getAllSortByIdAsc();
//    @Query("select u from User u order by u.id desc")
//    Set<User> getAllSortByIdDesc();
//    @Query("select u from User u order by u.username asc")
//    Set<User> getAllSortByUsernameAsc();
//    @Query("select u from User u order by u.username desc")
//    Set<User> getAllSortByUsernameDesc();
//    @Query("select u from User u order by u.email asc")
//    Set<User> getAllSortByEmailAsc();
//    @Query("select u from User u order by u.email desc")
//    Set<User> getAllSortByEmailDesc();
//    @Query("select u from User u order by u.registeredOn asc")
//    Set<User> getAllSortByRegisteredOnAsc();
//    @Query("select u from User u order by u.registeredOn desc")
//    Set<User> getAllSortByRegisteredOnDesc();
}
