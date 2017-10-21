package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.dao.api.StationDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StationDaoImp implements StationDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Station> getAllStations() {
        return em.createQuery("FROM Station")
                .getResultList();
    }


    @Override
    public void addNewStation(Station station) {
        em.persist(station);

    }

    @Override
    public void removeStation(Long stationId) {
        Station toDeleteStation = this.getStationById(stationId);
        em.remove(toDeleteStation);
    }

    @Override
    public Station getStationById(Long stationId) {
        List list = em.createQuery("FROM Station where stationId=:stationId")
                .setParameter("stationId",stationId).getResultList();
        return (list.isEmpty()) ? null : (Station) list.get(0);

    }

    @Override
    public Station getStationByName(String stationName) {

        List list = em.createQuery("FROM Station where stationName=:stationName")
                .setParameter("stationName", stationName).getResultList();
        return (list.isEmpty()) ? null : (Station) list.get(0);
    }
}
