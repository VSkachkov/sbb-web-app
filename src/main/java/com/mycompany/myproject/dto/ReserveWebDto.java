package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Reserve;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ReserveWebDto {
    private Long reserveId;
    private Long routeId;
    private Long trainId;
    private String stationFromName;
    private String stationToName;
    private Long stationFromId;
    private Long stationToId;
    private Time departure;
    private Time arrival;
    private Date travelDate;
    private Long userId;
    private String firstName;
    private String lastName;
    private Long carId;
    private String carName;
    private String trainName;
    private String trainTypeName;

    public ReserveWebDto(Reserve reserve) {
        this.reserveId = reserve.getReserveId();
        this.routeId = reserve.getRoute().getRouteId();
        this.trainId = reserve.getRoute().getTrain().getTrainId();
        this.stationFromName = reserve.getRoute().getSection().getStationFromId().getStationName();
        this.stationToName = reserve.getRoute().getSection().getStationToId().getStationName();
        this.stationFromId = reserve.getRoute().getSection().getStationFromId().getStationId();
        this.stationToId = reserve.getRoute().getSection().getStationToId().getStationId();
        this.departure = reserve.getRoute().getDeparture();
        this.arrival = reserve.getRoute().getArrival();
        this.travelDate = reserve.getTravelDate();
        this.userId = reserve.getUser().getUserId();
        this.firstName = reserve.getUser().getFirstName();
        this.lastName = reserve.getUser().getLastName();
        this.carId = reserve.getCar().getCarId();
        this.carName = reserve.getCar().getCarName();
        this.trainName = reserve.getRoute().getTrain().getTrainName();
        this.trainTypeName = reserve.getRoute().getTrain().getTrainTypeNumber().getTrainTypeName();
    }

    public ReserveWebDto() {
    }
}
