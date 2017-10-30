package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Route;

import java.util.List;

public interface RouteDao {

    List<Route> getAllRoutes();
    Route getRouteById(Long routeId);
    List<Route> getRouteOfTrain(Long trainId);
    void addNewRoute(Route route);
}
