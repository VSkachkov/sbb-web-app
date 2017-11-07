package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.Role;
import com.mycompany.myproject.dao.api.UserDao;
//import com.mycompany.myproject.service.impl.GenericServiceImpl;
import com.mycompany.myproject.service.svc.RoleService;
import com.mycompany.myproject.service.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl// extends GenericServiceImpl<User, UserDto, Long>
        implements UserService
{

    @Autowired
    UserDao userDao;

    @Autowired
    private RoleService roleService;


    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> sdto = new ArrayList<>();

        for (User user :
                userDao.getAllUsers()) {
            sdto.add(new UserDto(user));
        }
        return sdto;
    }

    @Transactional
    @Override
    public void addNewUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setPassword(userDto.getPassword());
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setBirthday(userDto.getBirthday());
        user.setPhone(userDto.getPhone());

        Role role = roleService.getRoleByName("ROLE_CLIENT");
        if (role!=null) {
            user.setRole(role);
        } else {
            role = new Role();
            role.setRoleName("ROLE_CLIENT");
            user.setRole(role);
        }

        userDao.addNewUser(user);

    }

    @Override
    public boolean doesUserExistInDb(UserDto userDto) {

        List<UserDto> usersDto= getAllUsers();
        for (UserDto userInDb:
                usersDto) {
            if (userInDb.getFirstName().equals(userDto.getFirstName())){
                if (userInDb.getLastName().equals(userDto.getLastName())){
                    if(userInDb.getBirthday().equals(userDto.getBirthday())){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    @Override
    public void removeUser(Long id) { //TODO IMPLEMENT METHOD

    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public long getUserIdByEmail(String email) {
        return userDao.getUserIdByEmail(email);
    }

    @Override
    public long getUserIdByLogin(String login) {
        return userDao.getUserIdByLogin(login);
    }

    @Override
    public UserDto loginUser(String login, String password) {
        User user = userDao.loginUser(login,password);
        if(user!=null)
            return new UserDto(user);
        else
            return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);    }

    @Override
    public User getUserByLogin(String login) {
            return userDao.getUserByLogin(login);
    }

    @Override
    public Long getUserIdByPrivateInfo(UserDto user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        Date birthday = user.getBirthday();
        return userDao.getUserByPrivateData(firstName, lastName, birthday);
    }
}