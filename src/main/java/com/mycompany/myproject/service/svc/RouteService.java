package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.Section;

import java.sql.Time;
import java.util.List;

public interface RouteService {
    /**
     * extracts all routes from db
     *
     * @return routes
     */
    List<Route> getAllRoutes();

    /**
     * finds route by route ID
     * @param routeId
     * @return route
     */
    Route getRouteById(Long routeId);

    /**
     * adds new route to db
     * @param route
     */
    void addNewRoute(Route route);

    /**
     * finds routes by section ID
     * @param sectionId
     * @return routes by this section
     */
    List<Route> getRoutesBySectionId(Long sectionId);

    /**
     * fins routes by section
     * @param section
     * @return routes
     */
    List<Route> getRoutesBySection(Section section);

    /**
     * gets routes DTOs by section
     * @param sectionId
     * @return
     */
    List<RouteDto> getRoutesDtosBySection(Long sectionId);

    /**
     * gets routes via station
     * @param stationId station ID
     * @return routes
     */
    List<Route> getRoutesViaStationId(Long stationId);

    /**
     * finds train departure time by time and station
     * @param stationId
     * @param trainId
     * @return
     */
    Time getTrainDepartureByStation(Long stationId, Long trainId);

    /**
     * gets routes from one station to another
     * @param stationFrom
     * @param stationTo
     * @param trainId
     * @return routes
     */
    List<Route> getRoutesFromOneStToOtherByTrain(Long stationFrom, Long stationTo, Long trainId);

    /**
     * turns routes to DTOs
     * @param routes
     * @return route DTOs
     */
    List<RouteDto> turnRoutesToDtos(List<Route> routes);

    /**
     * gets routes DTOs via station by ID
     * @param stationId
     * @return DTOs
     */
    List<RouteDto> getRoutesDtosViaStationId(Long stationId);

    /**
     * gets routes of train
     * @param trainId train ID
     * @return routes DTOs
     */
    List<RouteDto> getRoutesOfTrain(Long trainId);

    /**
     * gets station where train starts
     * @param trainId train ID
     * @return station ID
     */
    Long getInitStationIdOfTrain(Long trainId);

    /**
     * gets last station of train
     * @param trainId train id
     * @return station ID
     */
    Long getLastStationIdOfTrain(Long trainId);

    /**
     * gets first station name of train route
     * @param trainId train id
     * @return station name
     */
    String getInitStationNameOfTrain(Long trainId);

    /**
     * gets last station name of train route
     * @param trainId train id
     * @return station name
     */
    String getLastStationNameOfTrain(Long trainId);

    /**
     * gets train arrival time on station
     * @param stationId station id
     * @param trainId train id
     * @return arrival time
     */
    Time getTrainArrivalByStation(Long stationId, Long trainId);

    /**
     * find all routes and converts them to dto
     * @return
     */
    List<RouteDto> getAllRoutesDto();

    /**
     * adds new route from web
     * @param routeDto route DTO
     * @return train if OK
     */
    boolean addRouteFromWeb(RouteDto routeDto);

    /**
     * deletes route from web by params in DTO
     * @param routeDto DTO
     * @return true if OK
     */
    boolean deleteRouteFromWeb(RouteDto routeDto);
}
