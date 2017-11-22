package com.mycompany.myproject.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.mycompany.myproject.dto.RoleDto;
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


    @Autowired
    private MessageSource ms;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        logger.debug("redirect to home page");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }



    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public @ResponseBody List<UserDto> usersList() {
        logger.info("Request of users JSON list");
        return userService.getAllUsers();
    }



    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        logger.info("Displaying information about users");
        ModelAndView mv= new ModelAndView("usersView");
        mv.addObject("usersModel", userService.getAllUsers());
        return mv;
    }

    @RequestMapping(value = "/linkToHelloWorld", method = RequestMethod.GET)
    public ModelAndView sendHello() {
        return new ModelAndView("helloWorld");
    }


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
    @RequestMapping(value = "/updateUserRole", method = RequestMethod.POST)
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

}



