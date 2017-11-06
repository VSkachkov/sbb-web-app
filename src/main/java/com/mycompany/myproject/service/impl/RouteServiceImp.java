package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.RouteDao;
import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.service.svc.RouteService;
import com.mycompany.myproject.service.svc.SectionService;
import com.mycompany.myproject.service.svc.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class RouteServiceImp implements RouteService {

    @Autowired
    RouteDao routeDao;

    @Autowired
    SectionService sectionService;

    @Autowired
    StationService stationService;


    @Override
    public List<Route> getAllRoutes() {
        return routeDao.getAllRoutes();
    }

    @Override
    public Route getRouteById(Long routeId) {
        return routeDao.getRouteById(routeId);
    }

    @Override
    public void addNewRoute(Route route) {

    }

    @Override
    public List<Route> getRoutesBySectionId(Long sectionId) {

        return routeDao.getRoutesBySection(sectionService.getSectionById(sectionId));
    }

    @Override
    public List <Route> getRoutesBySection(Section section){
        return routeDao.getRoutesBySection(section);
    }

    @Override
    public List<RouteDto> getRoutesDtosBySection(Long sectionId) {

        return null;
    }

    @Override
    public List<Route> getRoutesViaStationId(Long stationId){
        List<Section> sectionsOfStation = sectionService.getSectionsByStationId(stationId);
        List <Route> routesViaStation  = new ArrayList<>();

        for (Section section:
             sectionsOfStation) {
            List <Route> routesViaSection = routeDao.getRoutesBySection(section);
            for (Route route:
                 routesViaSection) {
                routesViaStation.add(route);
            }
        }
        return routesViaStation;
    }

    @Override
    public Time getTrainDepartureByStation(Long stationId, Long trainId) {
        List <Route> allTrainRoutes = routeDao.getRouteOfTrain(trainId);

        for (Route route :
                allTrainRoutes) {
            if (route.getSection().getStationFromId().getStationId()==stationId)
                return route.getDeparture();
        }
        return null;
    }

    @Override
    public List<Route> getRoutesFromOneStToOtherByTrain(Long stationFrom, Long stationTo, Long trainId) {
        List <Route> allTrainRoutes = routeDao.getRouteOfTrain(trainId);
        List <Route> routesBetweenStations = new ArrayList<>();
        Route routeFrom = null;
        Route routeTo = null;


        for (Route route:
             allTrainRoutes) {
            if (route.getSection().getStationFromId().getStationId()==stationFrom)
                routeFrom = route;
            if (route.getSection().getStationToId().getStationId()==stationTo)
                routeTo = route;
        }

        for (Route route :
                allTrainRoutes) {
            if(route.getDeparture().getTime()>=routeFrom.getDeparture().getTime())
                if(route.getArrival().getTime()<=routeTo.getArrival().getTime())
                    routesBetweenStations.add(route);
        }

        return routesBetweenStations;
    }

    @Override
    public List<RouteDto> turnRoutesToDtos(List <Route> routes){
        List <RouteDto> routesDto = new ArrayList<>();
        for (Route route :
                routes) {
            routesDto.add(new RouteDto(route));
        }

        return routesDto;
    }

    @Override
    public List <RouteDto> getRoutesDtosViaStationId(Long stationId){
        List <Route> routes = this.getRoutesViaStationId(stationId);
        return this.turnRoutesToDtos(routes);
    }

    @Override
    public List<RouteDto> getRoutesOfTrain(Long trainId) {
        List <Route> routes = new ArrayList<>();
        routes = routeDao.getRouteOfTrain(trainId);
        List <RouteDto> routeDtos = new ArrayList<>();
        routeDtos = turnRoutesToDtos(routes);
        return routeDtos;
    }


    @Override
    public String getInitStationNameOfTrain(Long trainId){
        String initStation = "";
        Station station = stationService.getStationById(getInitStationIdOfTrain(trainId));
        if (station!= null){
            initStation = station.getStationName();
        }
        return initStation;
    }

    @Override
    public Long getInitStationIdOfTrain(Long trainId){
        Long iniStationId = null;
        List <Route> allRoutes = routeDao.getRouteOfTrain(trainId);
        if (!allRoutes.isEmpty()){
            iniStationId = allRoutes.get(0).getSection().getStationFromId().getStationId();
        }
        return iniStationId;
    }

    @Override
    public Long getLastStationIdOfTrain(Long trainId) {
        Long lastStationId = null;
        List <Route> allRoutes = routeDao.getRouteOfTrain(trainId);
        if (!allRoutes.isEmpty()){
            int size = allRoutes.size();
            lastStationId = allRoutes.get(size-1).getSection().getStationToId().getStationId();
        }
        return lastStationId;
    }

    @Override
    public String getLastStationNameOfTrain(Long trainId) {
        String lastStation = "";
        Long lastStationId = getLastStationIdOfTrain(trainId);
        Station station = stationService.getStationById(lastStationId);
        if (station!= null){
            lastStation = station.getStationName();
        }
        return lastStation;
    }

    @Override
    public Time getTrainArrivalByStation(Long stationId, Long trainId) {
        List <Route> allTrainRoutes = routeDao.getRouteOfTrain(trainId);

        for (Route route :
                allTrainRoutes) {
            if (route.getSection().getStationToId().getStationId()==stationId)
                return route.getArrival();
        }
        return null;
    }


}
