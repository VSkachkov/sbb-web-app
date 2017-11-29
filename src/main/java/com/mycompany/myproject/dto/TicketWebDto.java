package com.mycompany.myproject.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class TicketWebDto {
    private Long reserveId;
    private Long routeId;
    private Long trainId;
    private String stationFromName;
    private String stationToName;
    private Long stationFromId;
    private Long stationToId;
    private Time departure;
    private Time arrival;
    private Long travelDateL;
    private Long birthdayL;
    private Date travelDate;
    private Date birthday;
    private Long userId;
    private String firstName;
    private String lastName;
    private Long carId;
    private String carName;
    private String trainName;
    private String trainTypeName;
    private String userFirstStation;
    private String userLastStation;
    private String trainFirstStation;
    private String trainLastStation;
    private float finalPrice;

    public TicketWebDto(ReserveWebDto reserveWebDto) {
        this.reserveId = reserveWebDto.getReserveId();
        this.routeId = reserveWebDto.getRouteId();
        this.trainId = reserveWebDto.getTrainId();
        this.stationFromName = reserveWebDto.getStationFromName();
        this.stationToName = reserveWebDto.getStationToName();
        this.stationFromId = reserveWebDto.getStationFromId();
        this.stationToId = reserveWebDto.getStationToId();
        this.departure = reserveWebDto.getDeparture();
        this.arrival = reserveWebDto.getArrival();
        this.travelDate = reserveWebDto.getTravelDate();
        this.userId = reserveWebDto.getUserId();
        this.firstName = reserveWebDto.getFirstName();
        this.lastName = reserveWebDto.getLastName();
        this.carId = reserveWebDto.getCarId();
        this.carName = reserveWebDto.getCarName();
        this.trainName = reserveWebDto.getTrainName();
        this.trainTypeName = reserveWebDto.getTrainTypeName();
    }

    public TicketWebDto() {
    }
}
