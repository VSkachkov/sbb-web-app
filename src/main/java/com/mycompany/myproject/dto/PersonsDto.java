package com.mycompany.myproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonsDto {
    private List<PersonDto> persons;

    @Override
    public String toString() {
        return "PersonsDto{" +
                "persons=" + persons +
                '}';
    }
}
