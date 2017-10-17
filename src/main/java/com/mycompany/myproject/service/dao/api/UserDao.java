package com.mycompany.myproject.service.dao.api;

import com.mycompany.myproject.persist.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void addNewUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);
    User getUserByEmail(String s);
    User getUserByLogin(String s);
    long getUserIdByEmail(String email);
    long getUserIdByLogin(String login);
}
