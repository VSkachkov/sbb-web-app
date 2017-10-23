package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.dto.TrainsAttribute;

import java.sql.Date;
import java.util.List;


public interface TrainService //extends GenericService<Train, TrainDto, Long>
{
    /**
     * gets all trains DTOs from DB
     * @return trains DTOs
     */
    List<TrainDto> getAllTrains();

    /**
     * adds new train to DB
     * @param trainDto train DTO
     */
    void addNewTrain(TrainDto trainDto);

    /**
     * checks if train goes specific date
     * @param trainId train number
     * @param travelDate required date
     * @return true if train goes that day
     */
    boolean checkTrainDate(Long trainId, Date travelDate);

    /**
     * removes train from DB
     * @param id train id to be removed
     */
    void removeTrain(Long id);

    /**
     * provides train entity based on train number
     * @param id train number
     * @return train entity
     */
    Train getTrainByTrainId(Long id);

    /**
     * provides train DTO by it's ID
     * @param id train number
     * @return train DTO
     */
    TrainDto getTrainById(Long id);

    /**
     * removes trains from initial list that do not go required date
     * @param trainsInfo all trains list
     * @param date required date
     * @return trains that go that day
     */
    List <TrainsAttribute> filterTrainsByDate(List<TrainsAttribute> trainsInfo, Date date);
}
