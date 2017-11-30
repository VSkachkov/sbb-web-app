package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.svc.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.joda.time.DateTime;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class TicketServiceImp implements  TicketService {


    final private Long TENMINUTES = new java.sql.Time(0, 10, 0).getTime();
    final private Long HOUR = new java.sql.Time(1, 0, 0).getTime();;

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

    @Autowired
    ReserveService reserveService;

    @Autowired
    RouteService routeService;

    @Autowired
    RatesService ratesService;


    @Override
    public boolean buyWebTicket(TicketWebDto ticketWebDto){
        Long departureStation = ticketWebDto.getStationFromId();
        Long arrivalStation = ticketWebDto.getStationToId();
        Long trainId = ticketWebDto.getTrainId();
        Date travelDate = ticketWebDto.getTravelDate();
        if (!checkDateValidity(travelDate))
            return false;
        Time departure = routeService.getTrainDepartureByStation(departureStation,trainId );
  //      travelDate.setTime(travelDate.getTime()+departure.getTime());
        if (!trainService.checkTrainDate(trainId, travelDate))
            return false;
        java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        if(travelDate==today)
        if (!this.checkEnoughTimeBeforeDeparture(trainId, departureStation))
            return false;

        List<User> users = userService.findUsersByPersonalData(ticketWebDto.getFirstName(),
                    ticketWebDto.getLastName(), ticketWebDto.getBirthday());
        boolean samePassengerOnboard = false;
        if(users!=null)
        for (User user :
                users) {
            if(reserveService.isPassengerOnboard(trainId, departureStation, arrivalStation, travelDate, user.getUserId()))
            samePassengerOnboard = true;
        }

        if (samePassengerOnboard)
            return false;



        UserDto user = new UserDto(ticketWebDto.getFirstName(),
                ticketWebDto.getLastName(),
                ticketWebDto.getBirthday());
        if(!userService.doesUserExistInDb(user))
            userService.addNewUser(user);
        Long userId = userService.getUserIdByPrivateInfo(user);
        Long carId = ticketWebDto.getCarId();
        Date birthDay = ticketWebDto.getBirthday();
        float totalRate = ticketWebDto.getFinalPrice();


        reserveService.addRide(trainId, departureStation, arrivalStation, travelDate, userId, carId, totalRate);
        return true;
    }



    @Override
    public boolean checkDateValidity(Date travelDate){
        LocalDate now = new LocalDate();
        if (travelDate.getTime()<now.toDateTimeAtStartOfDay().getMillis())
            return false;
        else return true;
    }

    @Override
    public boolean checkEnoughTimeBeforeDeparture(Long trainId, Long stationId){
        LocalDate now = new LocalDate();
        DateTime currentDateTime = DateTime.now();
        Time sqlTimeDeparture = routeService.getTrainDepartureByStation(stationId, trainId);
        Long timeNow = currentDateTime.getMillis();
        Long sqlDateTimeDepartureToLong = sqlTimeDeparture.getTime()+now.toDateTimeAtStartOfDay().getMillis();
        Long latestPossibleTime = timeNow  + TENMINUTES;
        if(latestPossibleTime>sqlDateTimeDepartureToLong)
            return false;
        return true;
    }


}
