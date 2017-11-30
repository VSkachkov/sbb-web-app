package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.Section;

import java.util.List;

public interface RouteDao {

    List<Route> getAllRoutes();
    Route getRouteById(Long routeId);
    Route getRouteByTrainAndSection(Long trainId, Section section);
    List<Route>getRoutesBySection(Section section);
    List<Route> getRouteOfTrain(Long trainId);
    void addNewRoute(Route route);

    void deleteRoute(Route route);
}
