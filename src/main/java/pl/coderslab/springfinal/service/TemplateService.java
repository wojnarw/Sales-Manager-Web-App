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
    public List<Template> findAllWithUser();
    public List<Template> findAllWithThisUser(User user, int page, int size, String sortBy);
    public List<Template> findAllWithThisCreation(Creation creation);

    public Template findOneByIdWithAllData(Long id);
    public Set<Template> findAllWithAllData();
    int countAllByUserId(long id);
    List<Template> getLastFive();
    Template findOneByIdAndUser(Long id, User user);

}
