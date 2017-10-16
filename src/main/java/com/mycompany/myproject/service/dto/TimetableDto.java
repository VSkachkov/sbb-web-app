package com.mycompany.myproject.service.dto;

import com.mycompany.myproject.persist.entity.Timetable;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class TimetableDto {


    private Long timetableId;

    private Long trainNumber;

    private Long stationId;

    private String departure;

    private String arrival;

    public TimetableDto(Timetable timetable) {
        this.timetableId = timetable.getTimetableId();
        this.trainNumber = timetable.getTrain().getTrainNumber();
        this.stationId = timetable.getStation().getStationId();
        this.departure = timetable.getDeparture();
        this.arrival = timetable.getArrival();
    }

    public TimetableDto() {
    }
}
