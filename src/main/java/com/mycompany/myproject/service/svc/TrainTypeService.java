package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;

import java.util.List;

public interface TrainTypeService {

    /**
     * provides all DTOs of train types
     *
     * @return
     */
    List<TrainTypeDto> getAllTrainTypes();

    /**
     * provides DTO by train type ID
     * @param trainTypeId
     * @return
     */
    List<TrainTypeDto> getTrainTypeInfo(Long trainTypeId);

    /**
     * adds new train Type
     * @param TrainTypeDto
     * @return true if success
     */
    boolean addNewTrainType(TrainTypeDto TrainTypeDto);

    /**
     * adds new train type by parameters
     * @param typeNumber
     * @param carId
     * @param carNumber
     */
    void addNerTrainTypeByParams(Long typeNumber, Long carId, long carNumber);


    void deleteTrainTypeByTypeNumberAndCar(TrainTypeNumber trainTypeNumber, Car car);

    /**
     * get train type by unique combination of train type and carriage
     * @param trainTypeNumber
     * @param car
     * @return
     */
    TrainType getCarByTypeNumberAndCar(TrainTypeNumber trainTypeNumber, Car car);

    /**
     * deletes train type number from DB
     * @param trainTypeDto
     * @return true if ok
     */
    boolean deleteTrainTypeFromWeb(TrainTypeDto trainTypeDto);
}
