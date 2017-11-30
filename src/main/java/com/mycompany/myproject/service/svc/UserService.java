package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.dto.UserDto;

import java.sql.Date;
import java.util.List;

public interface UserService //extends GenericService<User, UserDto, Long>
{
    /**
     * gets all users DTOs
     * @return list of users DTOs
     */
    List<UserDto> getAllUsers();

    /**
     * adds new user to DB
     * @param user user DTO to be added
     */
    void addNewUser(UserDto user);

    /**
     * check user's existence in DB
     * @param userDto user data
     * @return true if user exists
     */
    boolean doesUserExistInDb(UserDto userDto);

    /**
     * removes user from id
     * @param id user'd id
     */
    void removeUser(Long id);

    /**
     * gets user's entity by it's id
     * @param id user id
     * @return user's entity
     */
    User getUserById(Long id);

    /**
     * gets user's id by it's email
     * @param email user's email
     * @return user's id
     */
    long getUserIdByEmail(String email);

    /**
     * gets user's id by it's login
     * @param login user's login
     * @return user's id
     */
    long getUserIdByLogin(String login);

    /**
     * returns user's DTO if login and password are correct
     * @param login user's login
     * @param password user's password
     * @return user's DTO
     */
    UserDto loginUser(String login, String password);

    /**
     * gets user's entity by it's email
     * @param email user's email
     * @return user's entity
     */
    User getUserByEmail(String email);

    /**
     * gets user's entity by it's login
     * @param login user's login
     * @return user's entity
     */
    User getUserByLogin(String login);

    /**
     * gets user's ID using it's info in user's DTO
     * @param user user DTO
     * @return user ID
     */
    Long getUserIdByPrivateInfo(UserDto user);

    void updateRole(Long userId, Long roleId);

    List<User> findUsersByPersonalData(String firstName, String lastName, Date birthday);
}
