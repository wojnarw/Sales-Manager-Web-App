package pl.coderslab.springfinal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.springfinal.entity.Publication;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long> {

}
