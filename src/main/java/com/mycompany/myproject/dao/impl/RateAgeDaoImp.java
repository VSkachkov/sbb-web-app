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
        return em.createQuery("FROM RateAge   order by ageLow")
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
        List list = em.createQuery("FROM RateAge where ageLow<=:ageInt  order by ageLow")
                .setParameter("ageInt",ageInt).getResultList();
        if (list.isEmpty())
            return (float)1;
        int size = list.size();
        RateAge rateAge = (RateAge)list.get(size-1);
        float rate = rateAge.getAgeRate();
        return (list.isEmpty()) ? 1 : rate;
    }
}
