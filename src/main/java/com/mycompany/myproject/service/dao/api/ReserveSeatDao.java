package com.mycompany.myproject.service.dao.api;

import com.mycompany.myproject.persist.entity.ReserveSeat;

import java.sql.Date;
import java.util.List;

public interface ReserveSeatDao {
    List<ReserveSeat> getAllReserveSeats();
    void addNewReserveSeat(ReserveSeat reserveSeat);

    void getReserveSeatsForTrainDate(Long trainId, Date travelDate);
}
