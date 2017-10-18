package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dao.api.StationDao;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dao.api.TrainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Time;
import java.util.List;

@Repository
public class TimetableDaoImpl implements TimetableDao{

    @Autowired
    StationDao stationDao;

    @Autowired
    TrainDao trainDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Timetable> getAllTimetable() {
        return em.createQuery("FROM Timetable ")
                .getResultList();
    }



    @Override
    public void addNewTimetable(Timetable timetable) {
        em.persist(timetable);

    }

    @Override
    public void removeTimetable(Long trainId) {

    }

    @Override
    public List<Timetable> getAllRouteOfTrain(Long trainId) {
        return null;
    }

    @Override
    public Time getArrival(Long trainId, Long stationId) {
        List<Timetable> timetable = em.createQuery("FROM Timetable where station=:stationId and train=:trainId ")
                .setParameter("stationId", stationDao.getStationById(stationId))
                .setParameter("trainId", trainDao.getTrainById(trainId))
                .getResultList();
        return timetable.get(0).getArrival();
    }

    @Override //TODO: IMPLEMENT THIS METHOD AFTER TRAINS ADDED TO PROJECT
    public Time getDeparture(Long trainId, Long stationId) {
        List<Timetable> timetable = em.createQuery("FROM Timetable where station=:stationId and train=:trainId ")
                .setParameter("stationId", stationDao.getStationById(stationId))
                .setParameter("trainId", trainDao.getTrainById(trainId))
                .getResultList();
        return timetable.get(0).getDeparture();
    }

    @Override
    public List<Timetable> getAllRoutesThroughStationId(Long stationId) {
        List list = em.createQuery("FROM Timetable where station=:stationId")
                .setParameter("stationId", stationDao.getStationById(stationId)).getResultList();
        return list;
    }

    @Override
    public List<Timetable> getAllTrainsThroughStationName(String stationName) {
        List list = em.createQuery("FROM Timetable where station=:stationId")
                .setParameter("stationId", stationDao.getStationByName(stationName)).getResultList();
        return list;
    }

//    @Override
//    public List<Long> getAllTrainIdThroughStationName(String stationName) {
//        List list = em.createQuery("SELECT trainNumber FROM Timetable t where station=:stationId")
//                .setParameter("trainNumber", trainNumber)
//                .setParameter("stationId", stationDao.getStationByName(stationName)).getResultList();
//        return list;
//    }
}


//    // BUTCKET ENTITY
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "PRODUCT_ID")
//    private ProductEntity productId;
//
//
//     // FROM BUCKET DAO IMPLEMENTATION
//    @Autowired
//    private ProductDAO productDAO;
//
//    @Override
//    public List<BucketEntity> getBucketsByProductId(long id) {
//
//        return  em.createQuery("from BucketEntity where productId=:id")
//                .setParameter("id", productDAO.getProductById(id)).getResultList();
//    }