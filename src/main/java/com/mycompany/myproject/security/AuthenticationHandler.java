//package com.mycompany.myproject.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//import com.mycompany.myproject.service.dto.UserDto;
//import com.mycompany.myproject.persist.entity.User;
//import com.mycompany.myproject.service.svc.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@Component
//public class AuthenticationHandler implements AuthenticationSuccessHandler {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
//                                        HttpServletResponse httpServletResponse,
//                                        Authentication authentication) throws IOException, ServletException {
//
//        HttpSession session = httpServletRequest.getSession();
//        UserDto user = (UserDto) session.getAttribute("user");
//        if (user == null) {
//            user = new UserDto();
//            session.setAttribute("user", user);
//        }
//
//        String loginName = authentication.getName();
//
//        if (loginName != null && user.getUserId() == 0) {
//
//            User userEntityByEmail = userService.getUserByEmail(loginName);
//            User userEntityByLogin = userService.getUserByLogin(loginName);
//            UserDto newUser = null;
//
//            if (userEntityByEmail != null) {
//                newUser = new UserDto(userEntityByEmail);
//            } else if (userEntityByLogin != null) {
//                newUser = new UserDto(userEntityByLogin);
//            }
//            if (newUser != null) {
//                //TODO IF USER HAS TICKETS. IMPLEMENT
//                session.setAttribute("user", newUser);
//            }
//        }
//
//
//        String redirectUrl = (String) session.getAttribute("url_prior_login");
//        if (redirectUrl != null) {
//            session.removeAttribute("url_prior_login");
//            httpServletResponse.sendRedirect(redirectUrl);
//        } else {
//            httpServletResponse.sendRedirect("/");
//        }
//
//    }
//}
//
