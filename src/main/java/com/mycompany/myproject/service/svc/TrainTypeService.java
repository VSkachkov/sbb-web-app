package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.TrainTypeDto;

import java.util.List;

public interface TrainTypeService {

    List<TrainTypeDto> getAllTrainTypes();
    public List<TrainTypeDto> getTrainTypeInfo(Long trainTypeId);
    void addNewTrainType(TrainTypeDto TrainTypeDto);

}
