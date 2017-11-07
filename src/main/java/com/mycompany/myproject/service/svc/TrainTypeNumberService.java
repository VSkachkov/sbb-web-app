package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.TrainTypeNumber;

import java.util.List;

public interface TrainTypeNumberService {
     List<TrainTypeNumber> getAllTrainTypesNumbers();

    Long add(TrainTypeNumber trainTypeNumber);

    TrainTypeNumber getTrainTypeNumberById(Long trainTypeNumberId);
}
