package com.mycompany.myproject.dto;

import java.sql.Date;

import com.mycompany.myproject.persist.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String email;

    private String login;

    private String password;

    private String phone;

    private String role;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthday = user.getBirthday();
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.role = user.getRole().getRoleName();
    }

    public UserDto(){
        this.role = "ROLE_ANONYM";

    }

    public UserDto(String firstName, String lastName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
}
