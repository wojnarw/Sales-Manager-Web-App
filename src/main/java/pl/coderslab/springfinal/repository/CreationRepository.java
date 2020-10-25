package pl.coderslab.springfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.springfinal.entity.Creation;

@Repository
public interface CreationRepository extends JpaRepository<Creation,Long> {

}
