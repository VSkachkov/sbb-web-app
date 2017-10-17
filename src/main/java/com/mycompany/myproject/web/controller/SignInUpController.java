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

@Controller
@Scope("request")
public class SignInUpController {
    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private MessageSource ms;

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "registration";
    }

    //TODO !! Add control for email!!!
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


        logger.error(userForm.getLastName());
        logger.error(userForm.getEmail());
        logger.error(userForm.getBirthday().toString());
        userService.addNewUser(userForm);
//        .addUser(userForm);
//        userForm.setId(userService.getUserIdByEmail(user.getEmail()));
//
//        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
//
//        userForm.setPass("");
//        userForm.setConfirmPassword("");
//        userForm.setProducts(user.getProducts());
//        model.addAttribute("user", userForm);

        return "/";
    }

//    @PostMapping(value = "/registration/findEmail/")
//    @ResponseBody
//    public String checkEmailExisting(@RequestParam String email) {
//        if (userService.getUserIdByEmail(email) != 0) {
//            return "this email already exists";
//        } else
//            return "";
//    }

//    @PostMapping(value = "/registration/findLogin/")
//    @ResponseBody
//    public String checkLoginExisting(@RequestParam String login) {
//        if (userService.getUserIdByLogin(login) != 0) {
//            return "this login already exists";
//        } else
//            return "";
//    }
}

