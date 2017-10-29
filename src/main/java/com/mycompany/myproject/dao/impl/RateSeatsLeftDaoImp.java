package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.RateSeatsLeftDao;
import com.mycompany.myproject.persist.entity.RateSeatsLeft;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RateSeatsLeftDaoImp implements RateSeatsLeftDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<RateSeatsLeft> getAllSeatsLeftRates() {
        return em.createQuery("FROM RateSeatsLeft ")
                .getResultList();

    }

    @Override
    public float getSeatsLeftRateByOccupancy(float occupancy) {
        List list = em.createQuery("FROM RateSeatsLeft where seatsLeftLow<=:occupancy and seatsLeftHigh>:occupancy")
                .setParameter("occupancy",occupancy).getResultList();
        if (list.isEmpty())
            return (float)1;
        RateSeatsLeft rateSeatsLeft = (RateSeatsLeft)list.get(0);
        float rate = rateSeatsLeft.getSeatsLeftRate();
        return (list.isEmpty()) ? 1 : rate;

    }
}
