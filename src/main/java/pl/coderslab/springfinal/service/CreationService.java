package pl.coderslab.springfinal.service;

import org.springframework.stereotype.Service;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;

import java.util.List;
import java.util.Set;

public interface CreationService {
    public Creation save(Creation creation);
    public void delete (Creation creation);
    public Creation findOneById(Long id);
    public Creation findOneByName(String name);
    public List<Creation> findAll();
//    public List<Creation> getAllByPage(int page);
    //    public List<Creation> findAll(String sortType);
    public List<Creation> findAllWithThisUser(User user);
    public List<Creation> findAllWithThisTemplate(Template template);

    public Creation findOneByIdWithAllData(Long id);
    public Set<Creation> findAllWithAllData();
    int countAllByUserId(long id);

    List<Creation> findAllByUser(User user);
    Creation findOneByIdAndUser(Long id, User user);
    List<Creation> getLastFive();
}
