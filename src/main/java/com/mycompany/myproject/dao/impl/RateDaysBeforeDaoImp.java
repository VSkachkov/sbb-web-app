package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.RateDaysBeforeDao;
import com.mycompany.myproject.persist.entity.RateAge;
import com.mycompany.myproject.persist.entity.RateDaysBefore;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RateDaysBeforeDaoImp  implements RateDaysBeforeDao{

    @PersistenceContext
    private EntityManager em;



    @Override
    public List<RateDaysBefore> getAllRatesDaysBefore() {
        return em.createQuery("FROM RateDaysBefore order by daysBeforeLow")
                .getResultList();
    }

    @Override
    public void addNewRateDaysBefore(RateDaysBefore rateDaysBefore) {
        em.persist(rateDaysBefore);
    }

    @Override
    public void removeRateDaysBefore(Long rateId) {

    }

    @Override
    public float getRateDaysBeforeByDays(int daysBefore) {
        List list = em.createQuery("FROM RateDaysBefore where daysBeforeLow<=:daysBefore order by daysBeforeLow")
                .setParameter("daysBefore",daysBefore).getResultList();
        if (list.isEmpty())
            return (float)1;
        int size = list.size();
        RateDaysBefore rateDaysBefore = (RateDaysBefore)list.get(size-1);
        float rate = rateDaysBefore.getDaysBeforeRate();
        return (list.isEmpty()) ? 1 : rate;
    }
}
