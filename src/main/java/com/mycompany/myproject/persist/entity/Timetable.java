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
    @Column (name = "train_type_id")
    private Long train_type_id;

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

    public Long getTrain_type_id() {
        return train_type_id;
    }

    public void setTrain_type_id(Long train_type_id) {
        this.train_type_id = train_type_id;
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
