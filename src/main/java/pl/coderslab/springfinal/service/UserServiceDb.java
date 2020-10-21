package pl.coderslab.springfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceDb implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceDb(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public User findOneById(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public User findOneByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User findOneByIdWithAllData(Long id) {
        return this.userRepository.findOneByIdWithAllData(id);
    }

    @Override
    public long count() {
        return this.userRepository.count();
    }

    @Override
    public Set<User> findAllWithAllData() {
        return this.userRepository.findAllWithAllData();
    }

//    @Override
//    public Set<User> getLast(int count) {
//        Query query = this.userRepository.getLast();
//        Set<User> lastUsers = query.setMaxResults(count);
//        return lastUsers;
//    }

    @Override
    public Set<User> getLastFive() {
        return this.userRepository.getLastFive();
    }

    @Override
    public List<User> getAll(String sortType) {
        List<User> users;
        switch (sortType) {
            case "idAsc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
                break;
            case "idDesc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
                break;
            case "usernameAsc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
                break;
            case "usernameDesc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.DESC, "username"));
                break;
            case "emailAsc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
                break;
            case "emailDesc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.DESC, "email"));
                break;
            case "dateAsc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "registeredOn"));
                break;
            case "dateDesc":
                users = this.userRepository.findAll(Sort.by(Sort.Direction.DESC, "registeredOn"));
                break;
            default: users = this.userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        }
        return users;
    }
}
