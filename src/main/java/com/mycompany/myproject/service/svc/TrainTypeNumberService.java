package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.TrainTypeNumber;

import java.util.List;

public interface TrainTypeNumberService {
    /**
     * extracts all train type numbers from DB
     *
     * @return
     */
    List<TrainTypeNumber> getAllTrainTypesNumbers();

    /**
     * adds new train type number
     * @param trainTypeNumber
     * @return
     */
    Long add(TrainTypeNumber trainTypeNumber);

    /**
     * finds train type number entity by id
     * @param trainTypeNumberId
     * @return
     */
    TrainTypeNumber getTrainTypeNumberById(Long trainTypeNumberId);

    /**
     * gets train type by it's name
     * @param trainTypeName
     * @return
     */
    TrainTypeNumber getTrainTypeByName(String trainTypeName);

    /**
     * deletes train type number by ID
     * @param id train type number id
     */
    void deleteTrainTypeNumberById(Long id);
}
