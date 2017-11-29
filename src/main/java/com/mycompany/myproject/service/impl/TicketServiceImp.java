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
    public String launchBuyingProcedure(PassengerForm passengerForm){ //TODO: fix deprecated procedure
        String result="Success!";
        Date travelDate = passengerForm.getTravelDate();
        Long trainId = passengerForm.getTrainNumber();
        if (!trainService.checkTrainDate(trainId, travelDate))
            return result =  "Oops, something went wrong. Seems that train does not go this day";

        Long departureStation = (stationService.getStationByName(passengerForm.getFromStation())).getStationId();
        Long arrivalStation = (stationService.getStationByName(passengerForm.getToStation())).getStationId();
        DateTime currentDateTime = DateTime.now();
        LocalTime localTime = new LocalTime(currentDateTime);
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
        if (reserveSeatService.isPassengerOnboard(trainId, chainOfStations, travelDate, userId))
            return "Error. This passenger has been registered on this train earlier.";
        reserveSeatService.addNewRide(trainId, chainOfStations,travelDate, userId );


        return result;
    }

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

//        boolean isPassengerOnboard =
//                reserveService.isPassengerOnboard(trainId, departureStation, arrivalStation, travelDate, userId);
//        if (!isPassengerOnboard)
//            return false;
        reserveService.addRide(trainId, departureStation, arrivalStation, travelDate, userId, carId, totalRate);
        return true;
    }

    @Override
    public String launchUpdatedBuyProcedure(PassengerForm passengerForm) {
        Long departureStation = (stationService.getStationByName(passengerForm.getFromStation())).getStationId();
        Long arrivalStation = (stationService.getStationByName(passengerForm.getToStation())).getStationId();
        Long trainId = passengerForm.getTrainNumber();
        Date travelDate = passengerForm.getTravelDate();
        if (!checkDateValidity(travelDate))
            return "Wrong travel date";

        Time departure = routeService.getTrainDepartureByStation(departureStation,trainId );
        travelDate.setTime(travelDate.getTime()+departure.getTime());

        if (!trainService.checkTrainDate(trainId, travelDate))
            return "Oops, something went wrong. Seems that train does not go this day";

        if (!this.checkEnoughTimeBeforeDeparture(trainId, departureStation))
            return "Ooops, something went wrong. Seems that train is gone or it is not enough time.";

        UserDto user = new UserDto(passengerForm.getFirstName(),
                passengerForm.getLastName(),
                passengerForm.getBirthday());
        if(!userService.doesUserExistInDb(user))
            userService.addNewUser(user);
        Long userId = userService.getUserIdByPrivateInfo(user);

        Long carId = passengerForm.getCarId();

        Date birthDay = passengerForm.getBirthday();
        float totalRate = launchPriceCalculation(birthDay, travelDate, trainId, carId );

        boolean isPassengerOnboard =
                reserveService.isPassengerOnboard(trainId, departureStation, arrivalStation, travelDate, userId);
        if (!isPassengerOnboard)
            return "Error. This passenger has been registered on this train earlier.";
        reserveService.addRide(trainId, departureStation, arrivalStation, travelDate, userId, carId, totalRate);
        return "Success!";
    }

    private float launchPriceCalculation(Date birthDay, Date travelDate, Long trainId, Long carId) {
        float totalRate = ratesService.calculateTotalRate(birthDay, travelDate, 20L, 450L);
        return totalRate;
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
