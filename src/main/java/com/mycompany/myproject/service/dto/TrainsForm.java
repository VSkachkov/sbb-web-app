package com.mycompany.myproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class TrainsForm {
    String stationFrom;
    String stationTo;
    String earlyTime = "0000";
    String lateTime = "2359";
    String travelDate;
    String travelTime;

    public TrainsForm() {
    }

    public TrainsForm(String stationFrom,
                      String stationTo,
                      String earlyTime,
                      String lateTime,
                      String traveDate,
                      String travelTime) {
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.earlyTime = earlyTime;
        this.lateTime = lateTime;
        this.travelDate= traveDate;
        this.travelTime = travelTime;
    }
}
