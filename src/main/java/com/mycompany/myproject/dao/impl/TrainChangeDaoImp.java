package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.TrainChangeDao;
import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.persist.entity.TrainChange;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository
public class TrainChangeDaoImp implements TrainChangeDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public TrainChange getChangeById(Long changeId) {
        List list  = em.createQuery("FROM TrainChange where changeId  =:changeId")
                .setParameter("changeId", changeId).getResultList();
        return  (list.isEmpty()) ? null : (TrainChange) list.get(0);
    }

    @Override
    public TrainChange getChangeByTrainDate(Train train, Date date) {
        List list  = em.createQuery("FROM TrainChange where train  =:train and travelDate=:date")
                .setParameter("train", train)
                .setParameter("date", date).getResultList();
        return  (list.isEmpty()) ? null : (TrainChange) list.get(0);
    }

    @Override
    public Date getDateByChangeId(Long changeId) {
        List list  = em.createQuery("FROM TrainChange where changeId  =:changeId")
                .setParameter("changeId", changeId).getResultList();
        TrainChange change = (list.isEmpty()) ? null : (TrainChange) list.get(0);
        Date  date = change.getTravelDate();
        return date;
    }

    @Override
    public String getStatusByChangeId(Long changeId) {
        List list  = em.createQuery("FROM TrainChange where changeId  =:changeId")
                .setParameter("changeId", changeId).getResultList();
        TrainChange change = (list.isEmpty()) ? null : (TrainChange) list.get(0);
        String  status = change.getStatus();
        return status;
    }

    @Override
    public void addTrainChange(TrainChange trainChange) {
        em.persist(trainChange);
    }

    @Override
    public void updateStatus(Train train, Date travelDate, String newStatus) {
        Query query = em.createQuery("UPDATE TrainChange set status=:status where train=:train and travelDate=:date")
                .setParameter("date", travelDate)
                .setParameter("train", train);
        query.executeUpdate();
    }

    @Override
    public void updateStatusByChangeId(Long changeId, String newStatus) {
        Query query = em.createQuery("UPDATE TrainChange set status=:status where changeId=:changeId")
                .setParameter("changeId", changeId)
                .setParameter("status", newStatus);
        query.executeUpdate();
    }

    @Override
    public List<TrainChange> getAllChanges() {
        List list  = em.createQuery("FROM TrainChange")
                .getResultList();
        return  (list.isEmpty()) ? null : list;
    }

    @Override
    public void deleteChange(long changeId) {
        em.remove((TrainChange) em.find(TrainChange.class, changeId));
    }

}
