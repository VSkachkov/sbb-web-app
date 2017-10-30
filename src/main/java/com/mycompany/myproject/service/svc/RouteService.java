package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Route;

import java.util.List;

public interface RouteService {
    List<Route> getAllRoutes();
    Route getRouteById();
    void addNewRoute(Route route);
}
