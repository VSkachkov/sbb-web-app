package com.mycompany.myproject.service.dto;

import java.util.Date;
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

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthday = user.getBirthday();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone = user.getPhone();
    }

    public UserDto(){

    }

}
