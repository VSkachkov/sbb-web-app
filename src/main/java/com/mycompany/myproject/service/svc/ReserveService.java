package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.ReserveWebDto;
import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.persist.entity.*;

import java.sql.Date;
import java.util.List;

public interface ReserveService {
    List<Reserve> getAllReserves();
    List <ReserveWebDto> getWebReserves();
    List<ReserveWebDto>getUserReserve(Long trainId, Long userId, Date date);
    boolean checkReserveInTicketsList(List<TicketWebDto> tickets, ReserveWebDto reserve);
    List<TicketWebDto> getAllJourneys();
    String getDepartureStation(List<ReserveWebDto> userReserve);
    String getArrivalStation(List<ReserveWebDto>userReserve);
    String getDepartureUserJourney(Long trainId, Long userId, Date date);
    String getArrivalUserJourney(Long trainId, Long userId, Date date);
    Reserve getReserveById(Long reserveId);
    List<Reserve> getReservesByUser(User user);
    List<Long> getStatisticsByLastMonth();
    void addReserve(Reserve reserve);
    Reserve getReserve(User user, Route route, Date travelDate);
    Long getStatisticsByDay(Date travelDate);

    boolean isPassengerOnboard(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId);

    void addRide(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId, Long carId,
                 float totalRate);

    Long getOccupancyByRoute(Route route, Car car, Date date);

    List<TicketWebDto> getTicketsByParams(Long trainId, Long travelDateL);
}
