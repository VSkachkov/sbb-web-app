package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Route;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class RouteDto {

    private Long routeId;
    private Long sectionId;
    private Long trainId;
    private Time departure;
    private Time arrival;
    private Long stationFromId;
    private Long stationToId;
    private String stationFromName;
    private String stationToName;
    private Long departureLong;
    private Long arrivalLong;


    public RouteDto() {
    }

    public RouteDto(Route route) {
        this.routeId = route.getRouteId();
        this.sectionId = route.getSection().getSectionId();
        this.trainId = route.getTrain().getTrainId();
        this.departure = route.getDeparture();
        this.arrival = route.getArrival();
        this.stationFromId = route.getSection().getStationFromId().getStationId();
        this.stationToId = route.getSection().getStationToId().getStationId();
        this.stationFromName = route.getSection().getStationFromId().getStationName();
        this.stationToName = route.getSection().getStationToId().getStationName();
    }
}
