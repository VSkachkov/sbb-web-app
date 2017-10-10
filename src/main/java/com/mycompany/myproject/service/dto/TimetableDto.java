package com.mycompany.myproject.service.dto;

import org.dozer.Mapping;

public class TimetableDto {

    @Mapping("trainNumber")
    private Long trainNumber;

    @Mapping ("train_type_id")
    private Long train_type_id;

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
