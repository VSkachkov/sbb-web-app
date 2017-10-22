package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.ReserveSeat;

import java.sql.Date;
import java.util.List;

public interface ReserveSeatService {

    List<ReserveSeat> getAllReserveSeats();
    void addNewReserveSeat(ReserveSeat reserveSeat);

    boolean checkFreeSeats(Long trainId, List<Long> chainOfStations, Date travelDate);

    void addNewRide(Long trainId, List<Long> chainOfStations, Date travelDate, Long userId);

    void getReserves(Long trainNumber, Date travelDate);

    boolean isPassengerOnboard(Long trainId, List<Long> chainOfStations, Date travelDate, Long userId);
}
