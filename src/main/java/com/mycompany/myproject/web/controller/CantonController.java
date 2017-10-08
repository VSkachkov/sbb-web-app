package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.service.CantonService;
import com.mycompany.myproject.service.dto.CantonDto;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("request")
public class CantonController {

    private static final Logger logger = LoggerFactory.getLogger(CantonController.class);

    @Autowired
    private DozerBeanMapper mapper;
//
//    @Autowired
//    private UserService userService;

    @Autowired
    private CantonService cantonService;

    @Autowired
    private MessageSource ms;
    
    
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView home() {
//        logger.debug("redirect to home page");
//        return new ModelAndView("home");
//    }

//
//    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
//    public @ResponseBody List<UserDto> usersList() {
//        logger.debug("get json user list");
//        return userService.findAll();
//    }
//
//
//
//    @RequestMapping(value = "users", method = RequestMethod.GET)
//    public ModelAndView getUsers() {
//        logger.debug("display user list");
//        ModelAndView mv= new ModelAndView("usersView");
//        mv.addObject("usersModel", userService.findAll());
//        return mv;
//    }

//    @RequestMapping(value = "/linkToHelloWorld", method = RequestMethod.GET)
//    public ModelAndView sendHello() {
//        return new ModelAndView("helloWorldJsp");
//    }


//        @RequestMapping(value = "/linkToAuthorities", method = RequestMethod.GET)
//    public @ResponseBody
//        String authoritiesList() {
//        return "Hello World";
//    }


        @RequestMapping(value = "/cantonsList", method = RequestMethod.GET)
    public @ResponseBody List<CantonDto> cantonsList() {
        logger.debug("get json cantons list");
        CantonDto m = new CantonDto();
        m.setId(5L);
        m.setName("Obwalden");
        cantonService.save(m);
        return cantonService.findAll();
    }


}    

 
