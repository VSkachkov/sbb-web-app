package com.mycompany.myproject.service.dto;

import org.dozer.Mapping;

public class TimetableDto {

    @Mapping("trainNumber")
    private Long trainNumber;

    @Mapping ("station_id")
    private Long station_id;

    @Mapping ("departure")
    private String departure;

    @Mapping ( "arrival")
    private String arrival;

    public Long getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Long trainNumber) {
        this.trainNumber = trainNumber;
    }


    public Long getStation_id() {
        return station_id;
    }

    public void setStation_id(Long station_id) {
        this.station_id = station_id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
}
