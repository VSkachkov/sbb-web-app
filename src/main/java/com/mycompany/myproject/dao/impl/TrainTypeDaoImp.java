package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.TrainTypeDao;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TrainTypeDaoImp implements TrainTypeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<TrainType> getAllTrainTypes() {
        List <TrainType> trainTypes = em.createQuery("FROM Train")
                .getResultList();
        return trainTypes;
    }

    @Override
    public List<TrainType> getTrainTypeInfo(Long trainTypeId){
        List<TrainType> trainTypes = em.createQuery("From TrainType WHERE trainTypeNumber=:trainTypeNumber")
                .setParameter("trainTypeNumber", this.getTrainTypeNumberById(trainTypeId)).getResultList();
        return trainTypes;
    }

    @Override
    public List<TrainTypeNumber> getAllTrainTypeNumber(){
        List <TrainTypeNumber> trainTypesNumber = em.createQuery("FROM TrainTypeNumber")
                .getResultList();
        return trainTypesNumber;
    }

    @Override
    public TrainTypeNumber getTrainTypeNumberById(Long trainTypeNumber){

        List list = em.createQuery("FROM TrainTypeNumber where trainTypeNumber=:trainTypeNumber")
                .setParameter("trainTypeNumber",trainTypeNumber).getResultList();
        return (list.isEmpty()) ? null : (TrainTypeNumber) list.get(0);
    }

    @Override
    public void addNewTrainType(List<TrainType> trainTypes) {

        for (TrainType trainType :
                trainTypes) {
            {
                em.persist(trainType);
            }
        }
    }

    @Override
    public void removeTrainType(Long id) {
        List<TrainType> trainTypes = this.getTrainTypeById(id);
        for (TrainType trainType:
             trainTypes) {

            em.remove(trainType);
        }
}

    @Override
    public List<TrainType> getTrainTypeById(Long trainId) {
        List <TrainType> trainTypes = em.createQuery("FROM Train where trainId=:trainId")
                .setParameter("trainId", trainId)
                .getResultList();
        return trainTypes;
    }
}
