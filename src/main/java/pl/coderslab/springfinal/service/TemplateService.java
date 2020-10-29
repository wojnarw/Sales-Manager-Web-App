package pl.coderslab.springfinal.service;

import org.springframework.data.domain.Page;
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
    public Page<Template> findAllWithThisUser(User user, int page, int size, String sortBy);

    public Template findOneByIdWithAllData(Long id);
    public Set<Template> findAllWithAllData();
    int countAllByUserId(long id);
    List<Template> getLastFive();
    Template findOneByIdAndUser(Long id, User user);

}
