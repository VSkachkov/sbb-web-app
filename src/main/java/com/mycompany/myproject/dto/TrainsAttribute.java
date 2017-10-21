package com.mycompany.myproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class TrainsAttribute {
    Long trainId;
    String stationFrom;
    Time departure;
    String stationTo;
    Time arrival;

    public TrainsAttribute(Long trainId, String stationFrom, Time departure, String stationTo, Time arrival) {
        this.trainId = trainId;
        this.stationFrom = stationFrom;
        this.departure = departure;
        this.stationTo = stationTo;
        this.arrival = arrival;
    }

    public TrainsAttribute() {
    }
}
