package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.RouteDao;
import com.mycompany.myproject.dao.api.TrainDao;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RouteDaoImp implements RouteDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    TrainDao trainDao;


    @Override
    public List<Route> getAllRoutes() {
        return em.createQuery("FROM Route ").getResultList();
    }

    @Override
    public List<Route> getRouteOfTrain(Long trainId){
        return em.createQuery("FROM Route WHERE train=:trainId order by departure")
        .setParameter("trainId", trainDao.getTrainById(trainId)).getResultList();
    }

    @Override
    public Route getRouteById(Long routeId) {
        List list  = em.createQuery("FROM Route Where routeId =:routeId")
        .setParameter("routeId", routeId).getResultList();
        return  (list.isEmpty()) ? null : (Route) list.get(0);
    }

    @Override
    public Route getRouteByTrainAndSection(Long trainId, Section section) {
        List list  = em.createQuery("FROM Route Where section =:section and train=:trainId")
                .setParameter("trainId", trainDao.getTrainById(trainId))
                .setParameter("section", section)
                .getResultList();
        return (list.isEmpty()) ? null : (Route) list.get(0);
    }

    @Override
    public List<Route> getRoutesBySection(Section section) {
        return em.createQuery("FROM Route WHERE section=:section")
                .setParameter("section", section).getResultList();
    }

    @Override
    public void addNewRoute(Route route) {
        em.persist(route);

    }
}
