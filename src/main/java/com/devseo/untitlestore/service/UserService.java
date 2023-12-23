package com.devseo.untitlestore.service;

import com.devseo.untitlestore.domain.User;
import com.devseo.untitlestore.repository.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int getCount() {
        return this.userDao.count();
    }
    public User getUser(String id) {
        return this.userDao.selectById(id);
    }
    public List<User> getUserList() {
        return this.userDao.selectAll();
    }
    public int create(User user) {
        return this.userDao.insert(user);
    }
    public int modify(User user) {
        return this.userDao.update(user);
    }
    public void remove(String id) {
        this.userDao.delete(id);
    }
    public void removeAll() {
        this.userDao.deleteAll();
    }
}
