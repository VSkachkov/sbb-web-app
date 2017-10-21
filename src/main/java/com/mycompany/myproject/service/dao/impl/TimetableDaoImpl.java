package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.persist.entity.Train;
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
public class TimetableDaoImpl implements TimetableDao {

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
        List list = em.createQuery("FROM Timetable where train=:trainId order by arrival")
                .setParameter("trainId",  trainDao.getTrainById(trainId)).getResultList();
        return list;
    }

    @Override
    public Time getArrival(Long trainId, Long stationId) {
        List<Timetable> timetable = em.createQuery("FROM Timetable where station=:stationId and train=:trainId ")
                .setParameter("stationId", stationDao.getStationById(stationId))
                .setParameter("trainId", trainDao.getTrainById(trainId))
                .getResultList();
        return timetable.get(0).getArrival();
    }

    @Override
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

    @Override
    public List<Timetable> getTrainsViaStationWithTime(String stationName, Time earlyTime, Time lateTime) {
        List list = em.createQuery("FROM Timetable where station=:stationId " +
                "                      and departure BETWEEN :earlyTime and :lateTime")
                .setParameter("stationId", stationDao.getStationByName(stationName))
                .setParameter("earlyTime", earlyTime)
                .setParameter("lateTime", lateTime).getResultList();
        return list;
    }

    @Override
    public Long getInitStationByTrain(Long trainId) {
        List<Timetable> timetable = em.createQuery("FROM Timetable where train=:trainId and arrival IS NULL ")
                .setParameter("trainId", trainDao.getTrainById(trainId))
                .getResultList();
        return timetable.get(0).getStation().getStationId();
    }

    @Override
    public Long getLastStationByTrain(Long trainId) {
        List<Timetable> timetable = em.createQuery("FROM Timetable where train=:trainId and departure IS NULL ")
                .setParameter("trainId", trainDao.getTrainById(trainId))
                .getResultList();
        return timetable.get(0).getStation().getStationId();
    }
}


