package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.service.dao.api.TrainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TrainDaoImp implements TrainDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Train> getAllTrains() {
        return em.createQuery("FROM Train")
                .getResultList();
    }

    @Override
    public void addNewTrain(Train train) {
        em.persist(train);
    }

    @Override
    public void removeTrain(Long id) {
        Train toDeleteTrain = this.getTrainById(id);
        em.remove(toDeleteTrain);
    }

    @Override
    public Train getTrainById(Long trainId) {
        List list = em.createQuery("FROM Train where trainId=:trainId")
                .setParameter("trainId",trainId).getResultList();
        return (list.isEmpty()) ? null : (Train) list.get(0);
    }
}
