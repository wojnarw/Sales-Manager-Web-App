package pl.coderslab.springfinal.service;

import pl.coderslab.springfinal.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User save(User user);
    public void delete (User user);
    public User findOneById(Long id);
    public User findOneByEmail(String email);
    public User findOneByIdWithAllData(Long id);
    long count();
    Set<User> findAllWithAllData();
    Set<User> getLastFive();
    List<User> getAll(String sortType);
    User findByUserName(String username);
}
