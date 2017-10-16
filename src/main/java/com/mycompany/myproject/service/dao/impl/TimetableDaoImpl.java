package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dao.api.StationDao;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TimetableDaoImpl implements TimetableDao{

    @Autowired
    StationDao stationDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Timetable> getAllTimetable() {
        return em.createQuery("FROM Timetable ")
                .getResultList();
    }



    @Override
    public void addNewTimetable(Timetable timetable) {

    }

    @Override //TODO: IMPLEMENT THIS METHOD AFTER TRAINS ADDED TO PROJECT
    public void removeTimetable(Long trainId) {

    }

    @Override //TODO: IMPLEMENT THIS METHOD AFTER TRAINS ADDED TO PROJECT
    public List<Timetable> getAllRouteOfTrain(Long trainId) {
        return null;
    }

    @Override
    public List<Timetable> getAllRoutesThroughStationId(Long stationId) {
        List list = em.createQuery("FROM Timetable where station=:stationId")
                .setParameter("stationId", stationDao.getStationById(stationId)).getResultList();
        return list;
    }

    @Override
    public List<Timetable> getAllRoutesThroughStationName(String stationName) {
        List list = em.createQuery("FROM Timetable where station=:stationId")
                .setParameter("stationId", stationDao.getStationByName(stationName)).getResultList();
        return list;
    }
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