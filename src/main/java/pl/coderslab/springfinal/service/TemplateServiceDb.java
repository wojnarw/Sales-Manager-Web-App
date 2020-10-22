package pl.coderslab.springfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.springfinal.entity.Publication;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.repository.TemplateRepository;

import java.util.List;
import java.util.Set;

@Service
public class TemplateServiceDb implements TemplateService {

    private TemplateRepository templateRepository;

    @Autowired
    public TemplateServiceDb(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public void save(Template template) {
        templateRepository.save(template);
    }

    @Override
    public void delete(Template template) {
        templateRepository.delete(template);
    }

    @Override
    public Template findOneById(Long id) {
        return templateRepository.getOne(id);
    }

    @Override
    public Template findOneByName(String name) {
        return templateRepository.findByName(name);
    }

    @Override
    public List<Template> findAll() {
        return templateRepository.findAll();
    }

    @Override
    public List<Template> findAllWithUser() {
        return null;
    }

    @Override
    public List<Template> findAllWithThisUser(User user) {
        return null;
    }

    @Override
    public List<Template> findAllWithThisPublication(Publication publication) {
        return null;
    }

    @Override
    public Template findOneByIdWithAllData(Long id) {
        return templateRepository.findOneByIdWithAllData(id);
    }
    @Override
    public Set<Template> findAllWithAllData() {
        return templateRepository.findAllWithAllData();
    }

    @Override
    public int countAllByUserId(long id) {
        return this.templateRepository.countAllByUserId(id);
    }

    @Override
    public Set<Template> getLastFive() {
        return this.templateRepository.getLastFive();
    }
}
