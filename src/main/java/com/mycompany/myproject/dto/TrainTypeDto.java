package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.TrainType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainTypeDto {
    private Long trainTypeNumber;
    private Long carId;
    private String trainTypeName;
    private Long numberOfCars;

    public TrainTypeDto() {
    }

    public TrainTypeDto(TrainType trainType) {
        this.trainTypeNumber = trainType.getTrainTypeNumber().getTrainTypeNumberId();
        this.carId = trainType.getCar().getCarId();
        this.trainTypeName = trainType.getTrainTypeName();
        this.numberOfCars = trainType.getNumberOfCars();
    }
}

