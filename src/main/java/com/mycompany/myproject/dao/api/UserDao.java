package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.User;

import java.sql.Date;
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
    User loginUser(String login, String password);
    Long getUserByPrivateData(String firstName, String lastName, Date birthday);
    void updateRole(Long userId, Long roleId);

    List<User> findUsersByPersonalData(String firstName, String lastName, Date birthday);
}
