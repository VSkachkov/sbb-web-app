package com.mycompany.myproject.service.dto;

import com.mycompany.myproject.persist.entity.Train;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDto {

    private Long trainId;
    private String TrainName;
    private boolean departMon;
    private boolean departTue;
    private boolean departWed;
    private boolean departThu;
    private boolean departFri;
    private boolean departSat;
    private boolean departSun;
    private Long capacity;

    public TrainDto() {
    }

    public TrainDto(Train train) {
        this.trainId = train.getTrainId();
        TrainName = train.getTrainName();
        this.departMon = train.isDepartMon();
        this.departTue = train.isDepartTue();
        this.departWed = train.isDepartWed();
        this.departThu = train.isDepartThu();
        this.departFri = train.isDepartFri();
        this.departSat = train.isDepartSat();
        this.departSun = train.isDepartSun();
        this.capacity = train.getCapacity();
    }
}
