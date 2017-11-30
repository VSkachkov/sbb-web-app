package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;

import java.util.List;

public interface TrainTypeService {

    List<TrainTypeDto> getAllTrainTypes();

    List<TrainTypeDto> getTrainTypeInfo(Long trainTypeId);

    boolean addNewTrainType(TrainTypeDto TrainTypeDto);

    void addNerTrainTypeByParams(Long typeNumber, Long carId, long carNumber);

    void deleteTrainTypeByTypeNumberAndCar(TrainTypeNumber trainTypeNumber, Car car);

    TrainType getCarByTypeNumberAndCar(TrainTypeNumber trainTypeNumber, Car car);

    boolean deleteTrainTypeFromWeb(TrainTypeDto trainTypeDto);
}
