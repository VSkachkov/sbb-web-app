package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.service.dto.PassengerForm;
import com.mycompany.myproject.service.dto.UserDto;
import com.mycompany.myproject.service.svc.TicketService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.service.svc.TrainService;
import com.mycompany.myproject.service.svc.UserService;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.joda.time.DateTime;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
@Transactional
public class TicketServiceImp implements  TicketService {


    final private Long TENMINUTES = new java.sql.Time(0, 10, 0).getTime();
    final private Long HOUR = new java.sql.Time(1, 0, 0).getTime();;

//    @Autowired
//    TicketDao ticketDao;

    @Autowired
    TrainService trainService;

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

    @Override
    public String launchBuyingProcedure(PassengerForm passengerForm){
        String result="Not clear";
        Long trainId = passengerForm.getTrainNumber();
        Date travelDate = passengerForm.getTravelDate();
        Long stationId = 21L;/// TODO INSERT CORRECT CODE!!! I.e. stationId where passenger wants to depart
        if (!trainService.checkTrainDate(trainId, travelDate))
            return result =  "Oops, something went wrong. Seems that train does not go this day";
//        java.util.Date today = new java.util.Date();
//        java.util.Date today = Calendar.getInstance(TimeZone.getDefault()).getTime();

        DateTime currentDateTime = DateTime.now();
        LocalTime localTime = new LocalTime(currentDateTime);
//        Time currentTime = new java.sql.Time(today.getTime());
        if (!timetableService.checkEnoughTimeBeforeDeparture(trainId, stationId, localTime, TENMINUTES))
            return result =  "Oops, something went wrong. It seem that you missed this train. " +
                                "Please, choose train that departs later.";

        UserDto user = new UserDto(passengerForm.getFirstName(),
                                   passengerForm.getLastName(),
                                   passengerForm.getBirthday());
        userService.doesUserExistInDb(user);
        return result;
    }
}
