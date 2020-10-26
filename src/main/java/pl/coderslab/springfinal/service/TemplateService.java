package pl.coderslab.springfinal.service;

import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;

import java.util.List;
import java.util.Set;

public interface TemplateService {
    public void save(Template template);
    public void delete (Template template);
    public Template findOneById(Long id);
    public Template findOneByName(String name);
    public List<Template> findAll();
//    public List<Template> getAllByPage(int page);
//    public List<Template> findAll(String sortType);
    public List<Template> findAllWithUser();
    public List<Template> findAllWithThisUser(User user);
    public List<Template> findAllWithThisCreation(Creation creation);

    public Template findOneByIdWithAllData(Long id);
    public Set<Template> findAllWithAllData();
    int countAllByUserId(long id);
    Set<Template> getLastFive();
    //find by created date
    //find by updated date
}
