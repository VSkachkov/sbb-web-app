package com.mycompany.myproject.web.controller;

import java.io.IOException;
import java.util.List;



import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
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



}



