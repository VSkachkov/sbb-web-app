//package com.mycompany.myproject.security;
//
//import com.mycompany.myproject.persist.entity.User;
//import com.mycompany.myproject.dao.api.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Service
//public class UserDetailsServiceImp implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) {
//        User user;
//        User userByEmail = userDao.getUserByEmail(s);
//        User userByLogin = userDao.getUserByLogin(s);
//        if(userByEmail != null) {
//            user = userByEmail;
//        } else if (userByLogin != null) {
//            user = userByLogin;
//        } else {
//            throw new UsernameNotFoundException(s);
//        }
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
//        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),grantedAuthorities);
//    }
//}
