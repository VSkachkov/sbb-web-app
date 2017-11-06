package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.ReserveDao;
import com.mycompany.myproject.persist.entity.Reserve;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.svc.CarService;
import com.mycompany.myproject.service.svc.ReserveService;
import com.mycompany.myproject.service.svc.RouteService;
import com.mycompany.myproject.service.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class ReserveServiceImp implements ReserveService {

    @Autowired
    ReserveDao reserveDao;

    @Autowired
    RouteService routeService;

    @Autowired
    UserService userService;

    @Autowired
    CarService carService;


    @Override
    public List<Reserve> getAllReserves() {
        return reserveDao.getAllReserves();
    }

    @Override
    public Reserve getReserveById(Long reserveId) {
        return reserveDao.getReserveById(reserveId);
    }

    @Override
    public List<Reserve> getReservesByUser(User user) {
        return reserveDao.getReservesByUser(user);
    }

    @Override
    public void addReserve(Reserve reserve) {
        reserveDao.addReserve(reserve);
    }

    @Override
    public Reserve getReserve(User user, Route route, Date travelDate){
        return reserveDao.getReserve(user, route, travelDate);
    }

    @Override
    public boolean isPassengerOnboard(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId) {
        List <Route> routes = routeService.getRoutesFromOneStToOtherByTrain(departureStation, arrivalStation, trainId);
        for (Route route:
             routes) {
            if (getReserve(userService.getUserById(userId), route, travelDate)!=null)
                return true;

        }
        return false;
    }

    @Override
    public void addRide(Long trainId, Long departureStation, Long arrivalStation,
                        Date travelDate, Long userId, Long carId, float totalRate) {
        List <Route> routes = routeService.getRoutesFromOneStToOtherByTrain(departureStation, arrivalStation, trainId);
        for (Route route:
                routes) {
            Reserve reserve = new Reserve();
            reserve.setTotalPriceRate(totalRate);
            reserve.setTravelDate(travelDate);
            reserve.setUser(userService.getUserById(userId));
            reserve.setRoute(route);
            reserve.setCar(carService.getCarById(carId));
            addReserve(reserve);
        }
    }
}
