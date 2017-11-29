package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;

import java.util.List;

public interface TrainTypeNumberDao {

    List<TrainTypeNumber> getAllTrainTypeNumbers();
    TrainTypeNumber getTrainTypeNumberById (Long trainTypeNumberId);
    TrainTypeNumber getTrainTypeByName (String trainTypeNumberName);
    Long add(TrainTypeNumber trainTypeNumber);
    void deleteTrainTypeNumberById(Long id);
}
