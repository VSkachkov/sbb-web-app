package com.mycompany.myproject.web.controller;

//import com.mycompany.myproject.security.SecurityService;
import com.mycompany.myproject.security.SecurityService;
import com.mycompany.myproject.service.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


}

