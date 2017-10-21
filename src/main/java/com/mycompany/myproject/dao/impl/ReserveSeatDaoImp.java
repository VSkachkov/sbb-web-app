package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.persist.entity.ReserveSeat;
import com.mycompany.myproject.dao.api.ReserveSeatDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ReserveSeatDaoImp implements ReserveSeatDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<ReserveSeat> getAllReserveSeats() {
        return em.createQuery("FROM ReserveSeat")
                .getResultList();
    }

    @Override
    public void addNewReserveSeat(ReserveSeat reserveSeat) {
        em.merge(reserveSeat); //
    }

//    @Override
//    public List<ReserveSeat> getReserveSeatsForTrainDate(Long trainId, Date travelDate) {
//        return em.createQuery("FROM ReserveSeat")
//                .getResultList();
//    }

}