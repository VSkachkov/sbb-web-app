package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.ReserveSeat;

import java.sql.Date;
import java.util.List;

public interface ReserveSeatService {

    /**
     * extracts all the information about reserves for all dates, passengers and trains
     * @return
     */
    List<ReserveSeat> getAllReserveSeats();

    /**
     * adds new reserve to database
     * @param reserveSeat
     */
    void addNewReserveSeat(ReserveSeat reserveSeat);

    /**
     * check availability for specific train, date, list of stations
     * @param trainId train ID in DB
     * @param chainOfStations list of stations IDs needed to be checked
     * @param travelDate date of travel
     * @return true when train has free seats and vise versa
     */
    boolean checkFreeSeats(Long trainId, List<Long> chainOfStations, Date travelDate);

    /**
     * adds new ride for passenger
     * @param trainId train ID
     * @param chainOfStations list of stations that passenger passes
     * @param travelDate date of travel
     * @param userId passenger id
     */
    void addNewRide(Long trainId, List<Long> chainOfStations, Date travelDate, Long userId);

    /**
     * get reserve of tickets
     * @param trainNumber tran number
     * @param travelDate date of travel
     */
    void getReserves(Long trainNumber, Date travelDate);

    /**
     * checks if passenger as already registered on thi train and date and passes station
     * @param trainId train is
     * @param chainOfStations list of stations that passenger passes
     * @param travelDate date of travel
     * @param userId passenger id
     * @return true if passenger already bought ticket on this train
     */
    boolean isPassengerOnboard(Long trainId, List<Long> chainOfStations, Date travelDate, Long userId);
}
