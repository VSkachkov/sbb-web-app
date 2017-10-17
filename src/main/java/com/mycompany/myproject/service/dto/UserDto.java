package com.mycompany.myproject.service.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.mycompany.myproject.persist.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapping;


@Getter
@Setter
public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String email;

    private String password;

    private String phone;

    private String role;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthday = user.getBirthday();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.role = user.getRole().getRoleName();
    }

    public UserDto(){
        this.role = "USER_ANONYM";

    }

    public UserDto(String firstName, String lastName, Date birthday, String email, String password, String phone, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }
}
