package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.ReserveSeat;

import java.util.List;

public interface ReserveSeatService {

    List<ReserveSeat> getAllReserveSeats();
    void addNewReserveSeat(ReserveSeat reserveSeat);
}
