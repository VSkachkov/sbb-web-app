package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.ReserveDao;
import com.mycompany.myproject.persist.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Repository
public class ReserveDaoImp implements ReserveDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Reserve> getAllReserves() {
        return em.createQuery("FROM Reserve ").getResultList();
    }

    @Override
    public Reserve getReserveById(Long reserveId) {
        List list = em.createQuery("FROM  Reserve WHERE reserveId=:reserveId")
                .setParameter("reserveId", reserveId).getResultList();
        return (list.isEmpty()) ? null : (Reserve) list.get(0);
    }

    @Override
    public List<Reserve> getReservesByUser(User user) {
        List list = em.createQuery("FROM Reserve  WHERE user =:user")
                .setParameter("user", user ).getResultList();
        return (list.isEmpty()) ? null :  list;
    }

    @Override
    public void addReserve(Reserve reserve) {
        em.merge(reserve);
        em.flush();
    }

    @Override
    public Reserve getReserve(User user, Route route, Date travelDate){
        List list = em.createQuery("FROM Reserve WHERE user =:user AND route=:route AND travelDate =:travelDate")
                .setParameter("user", user)
                .setParameter("route", route)
                .setParameter("travelDate", travelDate)
                .getResultList();
        return (list.isEmpty()) ? null : (Reserve) list.get(0);
    }

    @Override
    public Long getBoughtTickets(User user, Route route, Date travelDate) {
        return null;
    }

    @Override
    public Long getOccupancyByRoute(Route route, Car car, Date date) {
        List list = em.createQuery("FROM Reserve WHERE car=:car AND route=:route AND travelDate =:travelDate")
                .setParameter("car", car)
                .setParameter("route", route)
                .setParameter("travelDate", date)
                .getResultList();
        Long listSize = new Long (list.size());
        return listSize;
    }

    @Override
    public List<Reserve> getReservesByDay(Date travelDate) {
        List list = em.createQuery("FROM Reserve WHERE travelDate =:travelDate")

                .setParameter("travelDate", travelDate)
                .getResultList();
        return list;
    }


}
