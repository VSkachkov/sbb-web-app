package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.RouteDao;
import com.mycompany.myproject.persist.entity.Route;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RouteDaoImp implements RouteDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Route> getAllRoutes() {
        return em.createQuery("FROM Route ").getResultList();
    }

    @Override
    public List<Route> getRouteOfTrain(Long trainId){
        return em.createQuery("FROM Route WHERE train=:trainId order by departure")
        .setParameter("trainId", trainId).getResultList();
    }

    @Override
    public Route getRouteById(Long routeId) {
        return null;
    }

    @Override
    public void addNewRoute(Route route) {
        em.persist(route);

    }
}
