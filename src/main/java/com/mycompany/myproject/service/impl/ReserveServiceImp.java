package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.ReserveDao;
import com.mycompany.myproject.dto.ReserveWebDto;
import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.persist.entity.*;
import com.mycompany.myproject.service.svc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.krb5.internal.Ticket;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class ReserveServiceImp implements ReserveService {

    @Autowired
    ReserveDao reserveDao;

    @Autowired
    RouteService routeService;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    StationService stationService;


    @Override
    public List<Reserve> getAllReserves() {
        return reserveDao.getAllReserves();
    }

    @Override
    public List<ReserveWebDto> getWebReserves() {
        List<Reserve> reserves = this.getAllReserves();
        List<ReserveWebDto> reserveWebDtos = new ArrayList<>();
        for (Reserve reserve :
                reserves) {
            reserveWebDtos.add(new ReserveWebDto(reserve));
        }
        return reserveWebDtos;
    }

    @Override
    public List<ReserveWebDto> getUserReserve(Long trainId, Long userId, Date date) {
        List<ReserveWebDto> userJourneyReserves = new ArrayList<>();
        List<ReserveWebDto> allReserves = this.getWebReserves();
        for (ReserveWebDto webReserve :
                allReserves) {
            if (webReserve.getTrainId() == trainId)
                if (webReserve.getUserId() == userId)
                    if (webReserve.getTravelDate().getTime() == date.getTime())
                        userJourneyReserves.add(webReserve);
        }
        return userJourneyReserves;
    }

    @Override
    public List<TicketWebDto> getAllJourneys() {
        List<ReserveWebDto> reserves = this.getWebReserves();
        List<TicketWebDto> ticketWebDtos = new ArrayList<>();
        for (ReserveWebDto reserve :
                reserves) {
            if (!checkReserveInTicketsList(ticketWebDtos, reserve)){
                TicketWebDto ticketWebDto = new TicketWebDto(reserve);
                Long trainId = reserve.getTrainId();
                Long userId = reserve.getUserId();
                Date date = reserve.getTravelDate();
                String userFirstStation = this.getDepartureUserJourney(trainId, userId, date);
                String userLastStation = this.getArrivalUserJourney(trainId, userId, date);
                String trainFirstStation = routeService.getInitStationNameOfTrain(trainId);
                String trainLastStation = routeService.getLastStationNameOfTrain(trainId);
                ticketWebDto.setUserFirstStation(userFirstStation);
                ticketWebDto.setUserLastStation(userLastStation);
                ticketWebDto.setTrainFirstStation(trainFirstStation);
                ticketWebDto.setUserLastStation(trainLastStation);
                ticketWebDtos.add(ticketWebDto);
            }
        }
        return ticketWebDtos;
    }

    @Override
    public boolean checkReserveInTicketsList(List<TicketWebDto> tickets, ReserveWebDto reserve){
        for (TicketWebDto ticketWebDto :
                tickets) {
            if(ticketWebDto.getTrainId()==reserve.getTrainId())
                if(ticketWebDto.getUserId()== reserve.getUserId())
                    if(ticketWebDto.getTravelDate().getTime()==reserve.getTravelDate().getTime())
                        return true;
        }
        return false;
    }

    @Override
    public String getDepartureStation(List<ReserveWebDto> userReserve) {
        Long stationDepartureId = userReserve.get(0).getStationFromId();
        Time departure = userReserve.get(0).getDeparture();
        for (ReserveWebDto reserveWebDto :
                userReserve) {
            if (reserveWebDto.getDeparture().getTime() < departure.getTime()) {
                departure = reserveWebDto.getDeparture();
                stationDepartureId = reserveWebDto.getStationFromId();
            }
        }
        return stationService.getStationById(stationDepartureId).getStationName();
    }

    @Override
    public String getArrivalStation(List<ReserveWebDto> userReserve) {
        Long stationArrivalId = userReserve.get(0).getStationToId();
        Time arrival = userReserve.get(0).getArrival();
        for (ReserveWebDto reserveWebDto :
                userReserve) {
            if (reserveWebDto.getArrival().getTime() > arrival.getTime()) {
                arrival = reserveWebDto.getArrival();
                stationArrivalId = reserveWebDto.getStationToId();
            }
        }
        return stationService.getStationById(stationArrivalId).getStationName();
    }

    @Override
    public String getDepartureUserJourney(Long trainId, Long userId, Date date) {
        List<ReserveWebDto> userJourneyReserves = this.getUserReserve(trainId, userId, date);
        String firstUserStation = this.getDepartureStation(userJourneyReserves);
        return firstUserStation;
    }

    @Override
    public String getArrivalUserJourney(Long trainId, Long userId, Date date) {
        List<ReserveWebDto> userJourneyReserves = this.getUserReserve(trainId, userId, date);
        String lastUserStation = this.getArrivalStation(userJourneyReserves);
        return lastUserStation;
    }


    @Override
    public Reserve getReserveById(Long reserveId) {
        return reserveDao.getReserveById(reserveId);
    }

    @Override
    public List<Reserve> getReservesByUser(User user) {
        return reserveDao.getReservesByUser(user);
    }

    @Override
    public List<Long> getStatisticsByLastMonth() {
        List <Long> statistics = new ArrayList<>();
        java.util.Date endDate = new java.util.Date();
        java.util.Date startDate = new java.util.Date();
        startDate.setMonth(endDate.getMonth()-1);

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        while( !start.after(end)){
            java.util.Date targetDay = start.getTime();
            java.sql.Date sqlDate = new Date(targetDay.getTime());
            statistics.add(getStatisticsByDay(sqlDate));
            start.add(Calendar.DATE, 1);
        }


        return statistics;
    }

    @Override
    public void addReserve(Reserve reserve) {
        reserveDao.addReserve(reserve);
    }

    @Override
    public Reserve getReserve(User user, Route route, Date travelDate) {
        return reserveDao.getReserve(user, route, travelDate);
    }

    @Override
    public Long getStatisticsByDay(Date travelDate) {
        List <Reserve> reserves = reserveDao.getReservesByDay(travelDate);
        Long listSize = new Long (reserves.size());
        return (Long) listSize;
    }



    @Override
    public boolean isPassengerOnboard(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId) {
        List<Route> routes = routeService.getRoutesFromOneStToOtherByTrain(departureStation, arrivalStation, trainId);
        for (Route route :
                routes) {
            if (getReserve(userService.getUserById(userId), route, travelDate) != null)
                return true;
        }
        return false;
    }

    @Override
    public void addRide(Long trainId, Long departureStation, Long arrivalStation,
                        Date travelDate, Long userId, Long carId, float totalRate) {
        List<Route> routes = routeService.getRoutesFromOneStToOtherByTrain(departureStation, arrivalStation, trainId);
        for (Route route :
                routes) {
            Reserve reserve = new Reserve();
            reserve.setTotalPriceRate(totalRate);
            reserve.setTravelDate(travelDate);
            reserve.setUser(userService.getUserById(userId));
            reserve.setRoute(route);
            reserve.setCar(carService.getCarById(carId));
            addReserve(reserve);
        }
    }

    @Override
    public Long getOccupancyByRoute(Route route, Car car, Date date) {
        return reserveDao.getOccupancyByRoute(route, car, date);
    }

    @Override
    public List<TicketWebDto> getTicketsByParams(Long trainId, Long travelDateL) {
        List <TicketWebDto> allTickets = getAllJourneys();
        List <TicketWebDto> ticketByParams = new ArrayList<>();
        Date travelDate = new Date(travelDateL);
        for (TicketWebDto ticket :
                allTickets) {
            if (ticket.getTrainId()==trainId){
                Long datePassengerL = ticket.getTravelDate().getTime();
                if (datePassengerL.equals(travelDateL))
                    ticketByParams.add(ticket);
            }
        }
        return ticketByParams;
    }
}
