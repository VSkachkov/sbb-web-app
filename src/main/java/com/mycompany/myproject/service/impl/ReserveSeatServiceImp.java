package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.ReserveSeat;
import com.mycompany.myproject.dao.api.ReserveSeatDao;
import com.mycompany.myproject.service.svc.ReserveSeatService;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TrainService;
import com.mycompany.myproject.service.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class ReserveSeatServiceImp implements ReserveSeatService{

    @Autowired
    ReserveSeatDao reserveSeatDao;

    @Autowired
    TrainService trainService;

    @Autowired
    UserService userService;

    @Autowired
    StationService stationService;



    @Override
    public List<ReserveSeat> getAllReserveSeats() {
        return reserveSeatDao.getAllReserveSeats();
    }

    @Override
    public void addNewReserveSeat(ReserveSeat reserveSeat) {
        reserveSeatDao.addNewReserveSeat(reserveSeat);
    }

    @Override
    public boolean checkFreeSeats(Long trainId, List<Long> chainOfStations, Date travelDate) {

//        reserveSeatDao.getReserveSeatsForTrainDate(trainId, travelDate);
        return true; //TODO FINISH THIS METHOD
    }

    @Override
    public void addNewRide(Long trainId, List<Long> chainOfStations, Date travelDate, Long userId) {

        for (Long station:
             chainOfStations) {
            ReserveSeat reserve = new ReserveSeat();
            reserve.setTrainId(trainService.getTrainByTrainId(trainId));
            reserve.setStationId(stationService.getStationById(station));
            reserve.setTravelDate(travelDate);
            reserve.setUserId(userService.getUserById(userId));
            reserveSeatDao.addNewReserveSeat(reserve);
        }


    }

    @Override
    public void getReserves(Long trainNumber, Date travelDate) {
//        reserveSeatDao.getReserveSeatsForTrainDate(trainNumber, travelDate);
    }

    @Override
    public boolean isPassengerOnboard(Long trainId, List<Long> chainOfStations, Date travelDate, Long userId) {
        for (Long stationId :
                chainOfStations) {
            if (reserveSeatDao.isReserved(travelDate, userId, trainId, stationId)){
                return true;
            }
        }
        return false;
    }
}
