package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.ReserveSeat;
import com.mycompany.myproject.service.dao.api.ReserveSeatDao;
import com.mycompany.myproject.service.svc.ReserveSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReserveSeatServiceImp implements ReserveSeatService{

    @Autowired
    ReserveSeatDao reserveSeatDao;


    @Override
    public List<ReserveSeat> getAllReserveSeats() {
        return reserveSeatDao.getAllReserveSeats();
    }

    @Override
    public void addNewReserveSeat(ReserveSeat reserveSeat) {
        reserveSeatDao.addNewReserveSeat(reserveSeat);
    }
}
