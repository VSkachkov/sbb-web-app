package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.service.svc.*;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.joda.time.DateTime;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class TicketServiceImp implements  TicketService {


    final private Long TENMINUTES = new java.sql.Time(0, 10, 0).getTime();
    final private Long HOUR = new java.sql.Time(1, 0, 0).getTime();;

//    @Autowired
//    TicketDao ticketDao;

    @Autowired
    StationService stationService;

    @Autowired
    TrainService trainService;

    @Autowired
    UserService userService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    ReserveSeatService reserveSeatService;

    @Override
    public String launchBuyingProcedure(PassengerForm passengerForm){
        String result="Success!";
        Long trainId = passengerForm.getTrainNumber();
        Date travelDate = passengerForm.getTravelDate();
        if (!trainService.checkTrainDate(trainId, travelDate))
            return result =  "Oops, something went wrong. Seems that train does not go this day";
//        java.util.Date today = new java.util.Date();
//        java.util.Date today = Calendar.getInstance(TimeZone.getDefault()).getTime();

        Long departureStation = (stationService.getStationByName(passengerForm.getFromStation())).getStationId();
        Long arrivalStation = (stationService.getStationByName(passengerForm.getToStation())).getStationId();
        DateTime currentDateTime = DateTime.now();
        LocalTime localTime = new LocalTime(currentDateTime);
//        Time currentTime = new java.sql.Time(today.getTime());
        java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        if(travelDate==today)
        if (!timetableService.checkEnoughTimeBeforeDeparture(trainId, departureStation, localTime, TENMINUTES))
            return result =  "Oops, something went wrong. It seem that you missed this train. " +
                                "Please, choose train that departs later.";

        UserDto user = new UserDto(passengerForm.getFirstName(),
                                   passengerForm.getLastName(),
                                   passengerForm.getBirthday());
        if(!userService.doesUserExistInDb(user))
            userService.addNewUser(user);
        Long userId = userService.getUserIdByPrivateInfo(user);
        List<Long> chainOfStations = timetableService.getChainOfStations(trainId, departureStation, arrivalStation);

        boolean isFreeSeat = reserveSeatService.checkFreeSeats(trainId, chainOfStations, travelDate);

        if(!isFreeSeat){

            return result = "no free seats available!";
        }
        reserveSeatService.addNewRide(trainId, chainOfStations,travelDate, userId );


        return result;
    }
}
