package com.mycompany.myproject.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.mycompany.myproject.dto.RoleDto;
import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.security.SecurityUtils;
import com.mycompany.myproject.service.svc.RoleService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myproject.service.svc.UserService;
import com.mycompany.myproject.dto.UserDto;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Scope("request")
@SessionAttributes("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DozerBeanMapper mapper;
//
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @CrossOrigin
    @RequestMapping(value = "/getUserRoles", method = RequestMethod.GET)
    public @ResponseBody
    List<RoleDto> getUserRoles() {
        logger.info("Web-server requests user roles");
        List<RoleDto> roleDtosModified = new ArrayList<>();
        List<RoleDto> roleDtos = new ArrayList<>();
        roleDtos = roleService.getAllRoleDtos();

        for (RoleDto roleDto :
                roleDtos) {
            RoleDto role = roleDto;
            if (roleDto.getRoleName().equals("ROLE_CLIENT"))
                role.setRoleName("User");
            if (roleDto.getRoleName().equals("ROLE_ADMIN"))
                role.setRoleName("Admin");
            if (roleDto.getRoleName().equals("ROLE_MANAGER"))
                role.setRoleName("Manager");
            if (roleDto.getRoleName().equals("ROLE_ANONYM"))
                role.setRoleName("Anonym");
            roleDtosModified.add(role);
        }
        return roleDtosModified;
    }

    @CrossOrigin
    @RequestMapping(value = "/getUsersList", method = RequestMethod.GET)
    public @ResponseBody List<UserDto> getUsersList() {
        logger.info("Web-server requests users list");
        return userService.getAllUsers();
    }


    @CrossOrigin
    @RequestMapping(value = "/getUsersPage/{pageNum}", method = RequestMethod.GET)
    public @ResponseBody List<UserDto> getUsersByParams(@PathVariable int pageNum) {
        logger.info("Web-server requests users by page");
        List <UserDto> userDtos = userService.getAllUsers();
        int itemsPerPage = 10;
        List <UserDto> pagedUsers = new ArrayList<>();
        for (int i = 0; i < itemsPerPage; i++) {
            pagedUsers.add(userDtos.get((pageNum-1)*10+i));
        }
        return pagedUsers;
    }


    @CrossOrigin
    @RequestMapping(value = "/admin/updateUserRole", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> getUsersList(@RequestBody UserDto userDto, HttpServletResponse response) {
        logger.info("Web-server updates user role: "+ userDto.toString());
        ResponseEntity myResponse;
        List<Long> availableRoles = roleService.getRolesIds();
        if (!availableRoles.contains(userDto.getRoleId()))
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        if(userService.getUserById(userDto.getUserId())==null)
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

        userService.updateRole(userDto.getUserId(), userDto.getRoleId());
        myResponse = new ResponseEntity(HttpStatus.OK);
        return myResponse;
    }


    @CrossOrigin
    @RequestMapping(value = "/freeLogin/{login}", method = RequestMethod.GET)
    public @ResponseBody boolean checkLoginExistence(@PathVariable("login") String login) {
        logger.info("Web-server requests checks login availability");
        User user = userService.getUserByLogin(login);

        return (user==null);
    }

    @CrossOrigin
    @RequestMapping(value = "/freeEmail/{email}", method = RequestMethod.GET)
    public @ResponseBody boolean checkEmailExistence(@PathVariable("email") String email) {
        logger.info("Web-server requests checks email availability");
        return (userService.getUserByEmail(email)==null);
    }

    @CrossOrigin
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        logger.info("Web-server registers user: " + userDto.toString());
        boolean result = userService.saveNewUser(userDto);
        if(result)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody
    User getUserAccount()  {
        User user = userService.getUserByLogin(SecurityUtils.getCurrentLogin());
        user.setPassword(null);
        return user;
    }


}



