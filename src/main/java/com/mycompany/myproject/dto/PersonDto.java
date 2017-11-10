package com.mycompany.myproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class PersonDto implements Serializable {
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return "personDto{" +
                this +
                '}';
    }
}
