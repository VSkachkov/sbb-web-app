package com.mycompany.myproject.security;

import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.dao.api.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


//@Service
@Component("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    //    @Override
//    @Transactional
    public UserDetails loadUserByUsername(String s) {
        log.debug("Authenticating {}", s);
        User user;
        User userByEmail = userDao.getUserByEmail(s);
        User userByLogin = userDao.getUserByLogin(s);
        if (userByEmail != null) {
            user = userByEmail;
        } else if (userByLogin != null) {
            user = userByLogin;
        } else {
            throw new UsernameNotFoundException(s);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}
