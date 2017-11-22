package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.RateSeasonDao;
import com.mycompany.myproject.persist.entity.RateSeason;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RateSeasonDaoImp implements RateSeasonDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<RateSeason> getAllSeasonRates() {
        return em.createQuery("FROM RateSeason  order by dateLow")
                .getResultList();
    }

    @Override
    public float getSeasonRateByDay(int dayNumber) {
        List list = em.createQuery("FROM RateSeason where dateLow<=:dayNumber order by dateLow")
                .setParameter("dayNumber",dayNumber).getResultList();
        if (list.isEmpty())
            return (float)1;
        int size = list.size();
        RateSeason rateSeason = (RateSeason)list.get(size-1);
        float rate = rateSeason.getSeasonRate();
        return (list.isEmpty()) ? 1 : rate;

    }

    @Override
    public void addNewSeasonRate(RateSeason rateSeason){
        em.persist(rateSeason);
    }


}
