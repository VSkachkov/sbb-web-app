package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.dto.UserDto;
import com.mycompany.myproject.service.svc.GenericService;

import java.util.List;

public interface UserService //extends GenericService<User, UserDto, Long>
{
    List<UserDto> getAllUsers();
    void addNewUser(UserDto user);
    boolean doesUserExistInDb(UserDto userDto);
    void removeUser(Long id);
    User getUserById(Long id);
    long getUserIdByEmail(String email);
    long getUserIdByLogin(String login);
    UserDto loginUser(String login, String password);
    User getUserByEmail(String email);
    User getUserByLogin(String login);
}
