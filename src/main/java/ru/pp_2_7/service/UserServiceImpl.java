package ru.pp_2_7.service;


import ru.pp_2_7.repository.UserDao;
import ru.pp_2_7.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    public User show(int id) {
        return userDao.show(id);
    }

}