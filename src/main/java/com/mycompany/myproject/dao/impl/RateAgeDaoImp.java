package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.RateAgeDao;
import com.mycompany.myproject.persist.entity.RateAge;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RateAgeDaoImp implements RateAgeDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<RateAge> getAllAgeRates() {
        return em.createQuery("FROM RateAge ")
                .getResultList();
    }

    @Override
    public void addNewRateAge(RateAge rateAge) {
        em.persist(rateAge);
    }

    @Override
    public void removeRateAge(Long rateId) {

    }

    @Override
    public float getAgeRateByAge(int ageInt) {
        List list = em.createQuery("FROM RateAge where ageLow<=:ageInt and ageHigh>:ageInt")
                .setParameter("ageInt",ageInt).getResultList();
        if (list.isEmpty())
            return (float)1;
        RateAge rateAge = (RateAge)list.get(0);
        float rate = rateAge.getAgeRate();

       return (list.isEmpty()) ? 1 : rate;
    }
}
