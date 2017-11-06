package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.service.svc.RouteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class RouteServiceTest {

    @Autowired
    RouteService routeService;

    @Test
    public void testGetAllRoutes(){
        Assert.assertTrue(!routeService.getAllRoutes().isEmpty());
    }

    @Test
    public void testGetRoutesBySection(){
        List<Route> routes = routeService.getRoutesBySectionId(13L);
        Assert.assertTrue(!routes.isEmpty());
    }

    @Test
    public void testGetRoutesViaStationId(){
        List<Route> routesViaStation = routeService.getRoutesViaStationId(13L);
        Assert.assertTrue(!routesViaStation.isEmpty());
    }

    @Test
    public void testGetRoutesDtosViaStationId(){
        List<RouteDto> routeDtos = routeService.getRoutesDtosViaStationId(13L);
        Assert.assertTrue(!routeDtos.isEmpty());

    }

    @Test
    public void testGetRoutesFromOneStToOtherByTrain(){
        List <Route> routeoFTrainBetweenStations = routeService.getRoutesFromOneStToOtherByTrain(9L, 13L, 1L);
        Assert.assertTrue(!routeoFTrainBetweenStations.isEmpty());
    }

    @Test
    public void testGetTrainDepartureByStation(){
        Time departure = routeService.getTrainDepartureByStation(9L, 2L); //TODO error test
        Assert.assertTrue(departure!=null);
    }

    @Test
    public void testGetInitStationNameOfTrain(){
        String stationName = routeService.getInitStationNameOfTrain(1L);
        Assert.assertTrue(stationName.equals("Geneva Airport"));
    }

    @Test
    public void getInitStationIdOfTrain(){
        Long stationId = routeService.getInitStationIdOfTrain(1L);
        Assert.assertTrue(stationId == 41L);
    }

    @Test
    public void testGetLastStationIdOfTrain(){
        Long station = routeService.getLastStationIdOfTrain(1L);
        Assert.assertTrue(station!=null);
    }

    @Test
    public void testGetLastStationNameOfTrain(){
        String stationName = routeService.getLastStationNameOfTrain(1L);
        Assert.assertTrue(!stationName.equals(""));
    }
}
