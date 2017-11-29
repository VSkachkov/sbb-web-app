package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.persist.entity.TrainType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class TrainDto {

    private Long trainId;
    private String trainName;
    private boolean departMon;
    private boolean departTue;
    private boolean departWed;
    private boolean departThu;
    private boolean departFri;
    private boolean departSat;
    private boolean departSun;
    private Long capacity;
    private String initStation;
    private String lastStation;
    private Time departureTime;
    private Time arrivalTime;
    private Long trainTypeNumber;
    private String trainTypeName;
    private List<TrainTypeDto> trainTypeDtos = new ArrayList<>();
    public Long trainType;
    private HashMap<Long, Long> carriage;
    private String status;


    public TrainDto(Long trainId, String trainName, boolean departMon,
                    boolean departTue, boolean departWed, boolean departThu,
                    boolean departFri, boolean departSat, boolean departSun,
                    Long capacity, String initStation, String lastStation,
                    Time departureTime, Time arrivalTime) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.departMon = departMon;
        this.departTue = departTue;
        this.departWed = departWed;
        this.departThu = departThu;
        this.departFri = departFri;
        this.departSat = departSat;
        this.departSun = departSun;
        this.capacity = capacity;
        this.initStation = initStation;
        this.lastStation = lastStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public TrainDto() {
    }

    public TrainDto(Train train) {
        this.trainId = train.getTrainId();
        this.trainName = train.getTrainName();
        this.departMon = train.isDepartMon();
        this.departTue = train.isDepartTue();
        this.departWed = train.isDepartWed();
        this.departThu = train.isDepartThu();
        this.departFri = train.isDepartFri();
        this.departSat = train.isDepartSat();
        this.departSun = train.isDepartSun();
        this.trainTypeNumber = train.getTrainTypeNumber().getTrainTypeNumberId();
        this.trainTypeName = train.getTrainTypeNumber().getTrainTypeName();

//        TrainType trainType =
//        trainType.
//        this.trainTypeDtos = train.getTrainTypeNumber().
    }
}
