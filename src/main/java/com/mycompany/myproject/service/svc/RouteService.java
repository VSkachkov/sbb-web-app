package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.Section;

import java.sql.Time;
import java.util.List;

public interface RouteService {
    List<Route> getAllRoutes();

    Route getRouteById(Long routeId);

    void addNewRoute(Route route);

    List<Route> getRoutesBySectionId(Long sectionId);

    List<Route> getRoutesBySection(Section section);

    List<RouteDto> getRoutesDtosBySection(Long sectionId);

    List<Route> getRoutesViaStationId(Long stationId);

    Time getTrainDepartureByStation(Long stationId, Long trainId);

    List<Route> getRoutesFromOneStToOtherByTrain(Long stationFrom, Long stationTo, Long trainId);

    List<RouteDto> turnRoutesToDtos(List<Route> routes);

    List<RouteDto> getRoutesDtosViaStationId(Long stationId);

    List<RouteDto> getRoutesOfTrain(Long trainId);

    Long getInitStationIdOfTrain(Long trainId);

    Long getLastStationIdOfTrain(Long trainId);

    String getInitStationNameOfTrain(Long trainId);

    String getLastStationNameOfTrain(Long trainId);

    Time getTrainArrivalByStation(Long stationId, Long trainId);

    List<RouteDto> getAllRoutesDto();

    boolean addRouteFromWeb(RouteDto routeDto);

    boolean deleteRouteFromWeb(RouteDto routeDto);
}
