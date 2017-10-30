package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.RouteDao;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.service.svc.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RouteServiceImp implements RouteService {

    @Autowired
    RouteDao routeDao;


    @Override
    public List<Route> getAllRoutes() {
        return routeDao.getAllRoutes();
    }

    @Override
    public Route getRouteById() {
        return null;
    }

    @Override
    public void addNewRoute(Route route) {

    }
}
