package pl.coderslab.springfinal.service;

import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.repository.TemplateRepository;

import java.util.Arrays;
import java.util.HashSet;
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
        //TODO co z tym
        Pageable sortedById = PageRequest.of(0, 100, Sort.by("id").ascending());
        Page<Template> templatePage = templateRepository.findAll(sortedById);
        List<Template> templateList = templatePage.getContent();
        return templateList;
    }

    @Override
    public List<Template> findAllWithUser() {
        return null;
    }

    @Override
    public Page<Template> findAllWithThisUser(User user, int page, int size, String sortBy) {
        Set<String> sortTypes = new HashSet<>(Arrays.asList("id", "name", "description", "updatedAt"));
        if(!sortTypes.contains(sortBy)) sortBy = "id";
        Pageable specificPage = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<Template> templatePage = templateRepository.findAllByUser(user, specificPage);
        return templatePage;
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
    public List<Template> getLastFive(User user) {
        Pageable lastFiveSortedByDate = PageRequest.of(0, 5, Sort.by("updatedAt").descending());
        Page<Template> templatePage = templateRepository.findAllByUser(user, lastFiveSortedByDate);
        List<Template> templateList = templatePage.getContent();
        return templateList;
    }

    @Override
    public Template findOneByIdAndUser(Long id, User user) {
        return this.templateRepository.findOneByIdAndUser(id, user);
    }
}
