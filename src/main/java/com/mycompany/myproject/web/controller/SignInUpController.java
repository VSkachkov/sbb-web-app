package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.persist.entity.User;
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
    UserService userService;

    @GetMapping(value = {"/home"})
    public String home() {
        return "home";
    }

    @GetMapping(value = "/logout")
    public String logout (HttpSession session, Model model){
        model.addAttribute("user",new UserDto());
        session.invalidate();
        return "redirect:/home";
    }


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

    @PostMapping(value = "login")
    public  String SetUserSession(@ModelAttribute("user") UserDto user, Model model,
                                               HttpServletRequest request){

        try {
            logger.error("User enters login data ");
            logger.error("User enters login password " );

//            user.setRole("ROLE_CLIENT");
//            model.addAttribute("user", user);

            User usr = userService.getUserByLogin(user.getLogin());
            if (!(usr.getPassword().equals(user.getPassword()))){

                return "home";
            }

            UserDto userDto = new UserDto(usr);
            model.addAttribute("user", userDto);
            if (userDto.getRole().equals("ROLE_ADMIN"))
                return "managerPage";
            else
                return "home";
        }catch (Exception e){
            logger.error("Failure when user Signs In");
            return "404";

        }
    }



    @PostMapping(value = "/findEmail")
    @ResponseBody
    public String checkEmailExisting(@RequestParam String email) {
        if (userService.getUserIdByEmail(email)!=0) {
            return "this email already exists";
        } else
            return "";
    }
//    /// TODO Analize which version is better:
//    //
//    @PostMapping(value = "/login")
//    public String login(@ModelAttribute("user") UserDto user, Model model, HttpSession httpSession) {
//        UserDto su = userService.loginUser(user.getLogin(),user.getPass());
//        if (su!=null) {
//            su.setProducts(user.getProducts());
//            model.addAttribute("user", su);
//            return "redirect:/home";
//        }
//        else {
//            model.addAttribute("error", "Username or password is incorrect.");
//            return "login";
//        }
//    }

//    @GetMapping(value = "/logout")
//    public String logout(@ModelAttribute("user") SessionUser user, Model model) {
//        model.addAttribute("user",new SessionUser());
//        return "redirect:/login";
//    }


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

