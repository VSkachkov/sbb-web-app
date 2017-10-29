package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;

import java.util.List;

public interface TrainTypeDao {
    List<TrainType> getAllTrainTypes();
    List<TrainTypeNumber> getAllTrainTypeNumber();
    public List<TrainType> getTrainTypeInfo(Long trainTypeId);
    void addNewTrainType( List<TrainType> trainTypes);
    TrainTypeNumber getTrainTypeNumberById(Long id);
    void removeTrainType(Long id);
    List<TrainType> getTrainTypeById(Long id);


}
