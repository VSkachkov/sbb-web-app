package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.*;

import java.sql.Date;
import java.util.List;

public interface ReserveDao {
    List<Reserve> getAllReserves();
    Reserve getReserveById(Long reserveId);
    List <Reserve> getReservesByUser (User user);
    void addReserve(Reserve reserve);
    Reserve getReserve(User user, Route route, Date travelDate);
    Long getBoughtTickets(User user, Route route, Date travelDate);

    Long getOccupancyByRoute(Route route, Car car, Date date);

    List<Reserve> getReservesByDay(Date travelDate);
}
