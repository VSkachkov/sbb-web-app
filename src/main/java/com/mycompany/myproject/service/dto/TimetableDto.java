package com.mycompany.myproject.service.dto;

import com.mycompany.myproject.persist.entity.Timetable;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;


@Getter
@Setter
public class TimetableDto {


    private Long timetableId;

    private Long trainId;

    private Long stationId;

    private Time departure;

    private Time arrival;

    public TimetableDto(Timetable timetable) {
        this.timetableId = timetable.getTimetableId();
        this.trainId = timetable.getTrain().getTrainId();
        this.stationId = timetable.getStation().getStationId();
        this.departure = timetable.getDeparture();
        this.arrival = timetable.getArrival();
    }

    public TimetableDto() {
    }
}
