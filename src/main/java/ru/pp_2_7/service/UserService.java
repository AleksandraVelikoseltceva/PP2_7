package ru.pp_2_7.service;

import ru.pp_2_7.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll();

    User show(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
