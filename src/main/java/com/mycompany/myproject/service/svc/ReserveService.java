package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Reserve;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.User;

import java.sql.Date;
import java.util.List;

public interface ReserveService {
    List<Reserve> getAllReserves();
    Reserve getReserveById(Long reserveId);
    List<Reserve> getReservesByUser(User user);
    void addReserve(Reserve reserve);
    Reserve getReserve(User user, Route route, Date travelDate);

    boolean isPassengerOnboard(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId);

    void addRide(Long trainId, Long departureStation, Long arrivalStation, Date travelDate, Long userId, Long carId,
                 float totalRate);

}
