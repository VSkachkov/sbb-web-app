package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.persist.entity.User;
//import com.mycompany.myproject.security.SecurityService;
import com.mycompany.myproject.security.SecurityService;
import com.mycompany.myproject.service.svc.UserService;
import com.mycompany.myproject.util.WebException;
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
import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
@SessionAttributes("user")
public class SignInUpController {
    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private MessageSource ms;

    @Autowired
    private SecurityService securityService;

    @Autowired
    UserService userService;


    @GetMapping(value = {"/home"})
    public String home() {
        return "home";
    }

//
//    @PostMapping(value = "/findEmail")
//    @ResponseBody
//    public String checkEmailExisting(@RequestParam String email) {
//        if (userService.getUserIdByEmail(email)!=0) {
//            return "this email already exists";
//        } else
//            return "";
//    }
//

//
//    @GetMapping(value = "/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new UserDto());
//        return "registration";
//    }
//
//
//
//    @PostMapping(value = "/registration")
//    public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult,
//                               Model model) {
//
//        logger.info("Returning to main page after user registered in database");
//
//
//        userService.addNewUser(userForm);
//
//        return "redirect:/login";
//    }


}

