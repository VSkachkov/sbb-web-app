package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.StationDao;
import com.mycompany.myproject.dao.api.TrainDao;
import com.mycompany.myproject.dao.api.UserDao;
import com.mycompany.myproject.persist.entity.ReserveSeat;
import com.mycompany.myproject.dao.api.ReserveSeatDao;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TrainService;
import com.mycompany.myproject.service.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;


@Repository
public class ReserveSeatDaoImp implements ReserveSeatDao {

    @PersistenceContext
    private EntityManager em;


    @Autowired
    private UserDao userDao;

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private StationDao stationDao;

    @Override
    public List<ReserveSeat> getAllReserveSeats() {
        return em.createQuery("FROM ReserveSeat")
                .getResultList();
    }

    @Override
    public  boolean isReserved(Date travelDate, Long userId, Long trainId, Long stationId){
        List list = em.createQuery("FROM ReserveSeat where travelDate=:travelDate and userId=:userId and stationId=:stationId and trainId=:trainId")
                .setParameter("userId", userDao.getUserById(userId))
                .setParameter("trainId", trainDao.getTrainById(trainId))
                .setParameter("stationId", stationDao.getStationById(stationId))
                .setParameter("travelDate", travelDate)
                .getResultList();
         return (!(list.isEmpty()));
    }



    @Override
    public void addNewReserveSeat(ReserveSeat reserveSeat) {
        em.merge(reserveSeat); //
    }



}