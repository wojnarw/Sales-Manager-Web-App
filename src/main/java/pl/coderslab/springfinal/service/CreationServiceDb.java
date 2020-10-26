package pl.coderslab.springfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.springfinal.entity.Creation;
import pl.coderslab.springfinal.entity.Template;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.repository.CreationRepository;

import java.util.List;
import java.util.Set;

@Service
public class CreationServiceDb implements CreationService {

    private CreationRepository creationRepository;

    @Autowired
    public CreationServiceDb(CreationRepository creationRepository) {
        this.creationRepository = creationRepository;
    }

    @Override
    public Creation save(Creation creation) {
        return this.creationRepository.save(creation);
    }

    @Override
    public void delete(Creation creation) {
        this.creationRepository.delete(creation);
    }

    @Override
    public Creation findOneById(Long id) {
        return this.creationRepository.findById(id).orElse(null);
    }

    @Override
    public Creation findOneByName(String name) {
        return this.creationRepository.findByName(name);
    }

    @Override
    public List<Creation> findAll() {
        return this.creationRepository.findAll();
    }

    @Override
    public List<Creation> findAllWithThisUser(User user) {
        return null; //this.creationRepository.findAllWithThisUser(user);
    }

    @Override
    public List<Creation> findAllWithThisTemplate(Template template) {
        return null; //this.creationRepository.findAllWithThisTemplate(template);
    }

    @Override
    public Creation findOneByIdWithAllData(Long id) {
        return this.creationRepository.findOneByIdWithAllData(id);
    }

    @Override
    public Set<Creation> findAllWithAllData() {
        return this.creationRepository.findAllWithAllData();
    }

    @Override
    public int countAllByUserId(long id) {
        return this.creationRepository.countAllByUserId(id);
    }

}