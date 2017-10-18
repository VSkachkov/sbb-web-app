package com.mycompany.myproject.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class TrainsForm {
    String stationFrom;
    String stationTo;
    String earlyTime = "0000";
    String lateTime = "2359";

    public TrainsForm() {
    }

    public TrainsForm(String stationFrom, String stationTo, String earlyTime, String lateTime) {
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.earlyTime = earlyTime;
        this.lateTime = lateTime;
    }
}
