package com.mycompany.myproject.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PassengerForm {
    String firstName;
    String lastName;
    String fromStation;
    String toStation;
    Date birthday;
    Date travelDate;
    Long trainNumber;


    public PassengerForm(String firstName,
                         String lastName,
                         String fromStation,
                         String toStation,
                         Date birthday,
                         Date travelDate,
                         Long trainNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.birthday = birthday;
        this.travelDate = travelDate;
        this.trainNumber = trainNumber;
    }

    public PassengerForm() {

    }
}

