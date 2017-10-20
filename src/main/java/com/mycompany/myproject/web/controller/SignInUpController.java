package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.service.dto.UserDto;
import com.mycompany.myproject.service.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("request")
public class SignInUpController {
    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private MessageSource ms;

    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public String start(Model model, String error, HttpServletRequest request) {
        if (error != null)
            model.addAttribute("error", "Username or password is incorrect.");
        else {
            String referrer = request.getHeader("Referer");
            request.getSession().setAttribute("url_prior_login", referrer);
        }
        return "login";
    }



    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "registration";
    }

    //TODO. Add control for email
    // spring.io/guides/gs/validating-form-input/


    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult,
                               //@ModelAttribute("user") UserDto user,
                               Model model) {
//        userValidator.validate(userForm, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
        logger.error("SignInUpController works");


        userService.addNewUser(userForm);

        return "home";
    }


}

