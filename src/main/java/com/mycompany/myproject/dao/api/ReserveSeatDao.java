package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.ReserveSeat;

import java.sql.Date;
import java.util.List;

public interface ReserveSeatDao {
    List<ReserveSeat> getAllReserveSeats();
    void addNewReserveSeat(ReserveSeat reserveSeat);
    boolean isReserved(Date travelDate, Long userId, Long trainId, Long StationId);

}
