package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.ReserveWebDto;
import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.persist.entity.*;

import java.sql.Date;
import java.util.List;

public interface ReserveService {

    /**
     * gets all reserves from DB
     *
     * @return Reserves
     */
    List<Reserve> getAllReserves();

    /**
     * gets web reserves
     * @return
     */
    List<ReserveWebDto> getWebReserves();

    /**
     * get user reserve by params
     * @param trainId train ID
     * @param userId
     * @param date travel date
     * @return DTO with information about user travel
     */
    List<ReserveWebDto> getUserReserve(Long trainId, Long userId, Date date);

    /**
     * checks if there is reserve in list
     * @param tickets
     * @param reserve
     * @return
     */
    boolean checkReserveInTicketsList(List<TicketWebDto> tickets, ReserveWebDto reserve);

    /**
     * gets all journeys
     * @return
     */
    List<TicketWebDto> getAllJourneys();

    /**
     * extracts departure station name
     * @param userReserve
     * @return station name
     */
    String getDepartureStation(List<ReserveWebDto> userReserve);

    /**
     * extracts arrival station from list
     * @param userReserve
     * @return arrival station
     */
    String getArrivalStation(List<ReserveWebDto> userReserve);

    /**
     * extracts station where passenger gets to the train
     * @param trainId
     * @param userId
     * @param date
     * @return station name
     */
    String getDepartureUserJourney(Long trainId, Long userId, Date date);

    /**
     * finds station name where user leaves train
     * @param trainId
     * @param userId
     * @param date
     * @return
     */
    String getArrivalUserJourney(Long trainId, Long userId, Date date);

    /**
     * gets reserve by id
     * @param reserveId
     * @return
     */
    Reserve getReserveById(Long reserveId);

    /**
     * gets user reserves
     * @param user
     * @return
     */
    List<Reserve> getReservesByUser(User user);

    /**
     * gets statistics by last month
     * @return
     */
    List<Long> getStatisticsByLastMonth();

    /**
     * adds reserve to DB
     * @param reserve
     */
    void addReserve(Reserve reserve);

    /**
     * gets reserve by params
     * @param user
     * @param route
     * @param travelDate
     * @return reserve
     */
    Reserve getReserve(User user, Route route, Date travelDate);

    /**
     * provides number of passenger-route entities on a specific date
     * @param travelDate
     * @return number of passenger-sections
     */
    Long getStatisticsByDay(Date travelDate);

    /**
     * checks if passenger has been registered
     * @param trainId
     * @param departureStation
     * @param arrivalStation
     * @param travelDate
     * @param userId
     * @return
     */
    boolean isPassengerOnboard(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId);

    /**
     * adds ride to DB by params
     * @param trainId
     * @param departureStation
     * @param arrivalStation
     * @param travelDate
     * @param userId
     * @param carId
     * @param totalRate
     */
    void addRide(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId, Long carId,
                 float totalRate);

    /**
     * calculate how many seats are occupied in train in carriage
     * @param route
     * @param car
     * @param date
     * @return
     */
    Long getOccupancyByRoute(Route route, Car car, Date date);

    /**
     * gets ticket by parameters
     * @param trainId
     * @param travelDateL
     * @return
     */
    List<TicketWebDto> getTicketsByParams(Long trainId, Long travelDateL);
}
