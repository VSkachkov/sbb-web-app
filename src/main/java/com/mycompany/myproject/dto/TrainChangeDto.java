package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.TrainChange;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class TrainChangeDto {
    private long changeId;
    private Long trainId;
    private String trainName;
    private Date travelDate;
    private Long travelDateLong;
    private String status;
    private Time delayTime;

    public TrainChangeDto(TrainChange trainChange) {
        this.changeId = trainChange.getChangeId();
        this.trainId = trainChange.getTrain().getTrainId();
        this.trainName = trainChange.getTrain().getTrainName();
        this.travelDate = trainChange.getTravelDate();
        this.status = trainChange.getStatus();
        this.delayTime = trainChange.getDelayTime();

    }

    public TrainChangeDto() {
    }
}
