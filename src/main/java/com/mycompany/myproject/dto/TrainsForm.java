package com.mycompany.myproject.dto;

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
    String lateTime = "2359" ;
    Date travelDate;
    Time travelTimeFrom;
    Time travelTimeTo;

    public TrainsForm() {
    }

    public TrainsForm(String stationFrom,
                      String stationTo,
                      String earlyTime,
                      String lateTime,
                      Date traveDate,
                      Time travelTimeFrom,
                      Time travelTimeTo) {
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.earlyTime = earlyTime;
        this.lateTime = lateTime;
        this.travelDate= traveDate;
        this.travelTimeFrom = travelTimeFrom;
        this.travelTimeTo = travelTimeTo;
    }
}
