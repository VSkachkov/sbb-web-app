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
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private RoleService roleService;


    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> sdto = new ArrayList<>();

        for (User user :
                userDao.getAllUsers()) {
            UserDto userDto = new UserDto(user);
            userDto.setPassword(null);
            sdto.add(userDto);
        }
        return sdto;
    }

    @Transactional
    @Override
    public void addNewUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        if (userDto.getPassword() == null)
            user.setPassword("0000");
        else
            user.setPassword(userDto.getPassword());
        if (userDto.getLogin() == null)
            user.setLogin(userDto.getFirstName() + "." + userDto.getLastName());
        else
            user.setLogin(userDto.getLogin());

        if (userDto.getEmail() == null)
            user.setEmail(userDto.getFirstName() + "." + userDto.getLastName() + "@gmail.com");
        else
            user.setEmail(userDto.getEmail());
        if (userDto.getBirthday() == null)
            user.setBirthday(new Date(0L));
        else
            user.setBirthday(userDto.getBirthday());
        user.setPhone(userDto.getPhone());

        Role role = roleService.getRoleByName("ROLE_CLIENT");
        if (role != null) {
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

        List<UserDto> usersDto = getAllUsers();
        for (UserDto userInDb :
                usersDto) {
            if (userInDb.getFirstName().equals(userDto.getFirstName())) {
                if (userInDb.getLastName().equals(userDto.getLastName())) {
                    if (userInDb.getBirthday().equals(userDto.getBirthday())) {
                        return true;
                    }
                }
            }

        }
        return false;
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
        User user = userDao.loginUser(login, password);
        if (user != null)
            return new UserDto(user);
        else
            return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

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

    @Override
    public void updateRole(Long userId, Long roleId) {
        userDao.updateRole(userId, roleId);
    }

    @Override
    public List<User> findUsersByPersonalData(String firstName, String lastName, Date birthday) {
        return userDao.findUsersByPersonalData(firstName, lastName, birthday);
    }

    @Override
    public boolean saveNewUser(UserDto userDto) {
        this.addNewUser(userDto);
        return true;
    }
}
