//package com.mycompany.myproject.security;
//
//
//
//import com.mycompany.myproject.security.UserDetailsServiceImp;
//import com.mycompany.myproject.security.AuthenticationHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.mycompany")
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsServiceImp userDetailsService;
//
//    @Autowired
//    private AuthenticationHandler authenticationHandler;
//
//
//    @Autowired
//    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http
//                .authorizeRequests()
//                .antMatchers("/management/**").access("hasRole('ROLE_MANAGER')")
////                .antMatchers("/profile/**").access("hasRole('ROLE_CLIENT') or hasRole('ROLE_MANAGER')") //TODO OTHER PAGES
////                .antMatchers("/checkout/**").access("hasRole('ROLE_CLIENT') or hasRole('ROLE_MANAGER')")
//                .and().formLogin().loginPage("/login").usernameParameter("login").passwordParameter("pass")
//                .successHandler(authenticationHandler)
//                .and()
//                .exceptionHandling().accessDeniedPage("/403"); //TODO 403 ERROR
//        http.logout()
//                .permitAll()
//                .clearAuthentication(true);
//    }
//
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//}
//
