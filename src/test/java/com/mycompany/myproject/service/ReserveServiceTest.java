package com.mycompany.myproject.service;


import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.ReserveWebDto;
import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.persist.entity.Reserve;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.svc.CarService;
import com.mycompany.myproject.service.svc.ReserveService;
import com.mycompany.myproject.service.svc.RouteService;
import com.mycompany.myproject.service.svc.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class ReserveServiceTest {

    @Autowired
    ReserveService reserveService;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    RouteService routeService;

    @Test
    public void testGetAllReserves(){
        List<Reserve> reserves = reserveService.getAllReserves();
        Assert.assertTrue(!reserves.isEmpty());
    }

    @Test
    public void testGetReserveById(){
        Reserve reserve = reserveService.getReserveById(1L);
        Assert.assertTrue(reserve != null);
    }

    @Test
    public void testGetReservesByUser(){
        User user  = userService.getUserById(1L);
        List<Reserve> userReserves = reserveService.getReservesByUser(user);
        Assert.assertTrue(!userReserves.isEmpty());
    }

    @Test
    public void testAddReserve(){
        Reserve reserve = new Reserve();
        reserve.setCar(carService.getCarByName("ICN 2nd class"));
        reserve.setRoute(routeService.getRouteById(3L));
        reserve.setUser(userService.getUserById(1L));
        reserve.setTravelDate(new Date(2017, 11, 05));
        reserve.setTotalPriceRate(0.9f);
        reserveService.addReserve(reserve);
        Reserve addedReserve = reserveService.getReserveById(3L);
        Assert.assertTrue( addedReserve!= null);
    }

    @Test
    public void testGetReserve(){
        User user = userService.getUserById(1L);
        Route route = routeService.getRouteById(3L);
        Date date = reserveService.getReserveById(3L).getTravelDate();
        Reserve reserve = reserveService.getReserve(user, route, date);
        Assert.assertTrue(reserve!= null);
    }

    @Test
    public void testIsPassengerOnboard(){
        Date date = reserveService.getReserveById(3L).getTravelDate();
        boolean result = reserveService.isPassengerOnboard(1L, 41L, 9L, date, 1L);
        Assert.assertTrue(result);
    }

    @Test
    public void testAddRide(){
        Date date = reserveService.getReserveById(3L).getTravelDate();
        reserveService.addRide(1L, 44L, 13L, date, 1L, 4L, 0.9f);
        Assert.assertTrue(reserveService.getReserveById(4L)!=null);
    }

    @Test
    public void testGetAllWebReserves(){
        List <ReserveWebDto> webDtos = reserveService.getWebReserves();
        Assert.assertTrue(!webDtos.isEmpty());
    }

    @Test
    public  void testGetArrivalUserJourney(){
        Date date = reserveService.getReserveById(3L).getTravelDate();
        String arrivalStation = reserveService.getArrivalUserJourney(1L, 1L, date);
        Assert.assertTrue(arrivalStation!=null);
    }

    @Test
    public  void testGetDepartureUserJourney(){
        Date date = reserveService.getReserveById(3L).getTravelDate();
        String departureStation = reserveService.getDepartureUserJourney(1L, 1L, date);
        Assert.assertTrue(departureStation!=null);
    }

    @Test
    public void testGetAllJourneys(){
        List<TicketWebDto> tickets = reserveService.getAllJourneys();
        Assert.assertTrue(!tickets.isEmpty());
    }
}
