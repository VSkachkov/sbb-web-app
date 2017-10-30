package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.TrainTypeNumberDao;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TrainTypeNumberDaoImp implements TrainTypeNumberDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<TrainTypeNumber> getAllTrainTypeNumbers() {
        return em.createQuery("FROM TrainTypeNumber ").getResultList();
    }

    @Override
    public TrainTypeNumber getTrainTypeNumberById(Long trainTypeNumberId) {
        return null;
    }

    @Override
    public List<TrainType> getTrainTypeById(Long trainTypeNumberId) {

        return null;
    }
}
