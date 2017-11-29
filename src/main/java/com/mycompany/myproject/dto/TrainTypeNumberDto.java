package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import lombok.Data;

@Data
public class TrainTypeNumberDto {

    private Long trainTypeNumberId;
    private String trainTypeName;

    public TrainTypeNumberDto(TrainTypeNumber trainTypeNumber) {
        this.trainTypeNumberId = trainTypeNumber.getTrainTypeNumberId();
        this.trainTypeName = trainTypeNumber.getTrainTypeName();
    }

    public TrainTypeNumberDto() {
    }
}
