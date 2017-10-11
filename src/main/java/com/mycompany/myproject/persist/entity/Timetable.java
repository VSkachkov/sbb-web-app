package com.mycompany.myproject.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Timetable")
public class Timetable implements Serializable{
    @Id
    @Column(name = "trainNumber")
    private Long trainNumber;

    @Id
    @Column (name = "station_id")
    private Long station_id;

    @Id
    @Column (name = "departure")
    private String departure;

    @Id
    @Column (name = "arrival")
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
