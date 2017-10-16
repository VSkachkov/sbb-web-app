package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.dto.UserDto;
import com.mycompany.myproject.service.svc.GenericService;

import java.util.List;

public interface UserService //extends GenericService<User, UserDto, Long>
{
    List<UserDto> getAllUsers();
    void addNewUser(User user);
    void removeUser(Long id);
    UserDto getUserById(Long id);
}
