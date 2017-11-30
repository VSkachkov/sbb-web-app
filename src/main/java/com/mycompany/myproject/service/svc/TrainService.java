package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.dto.TrainsAttribute;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;


public interface TrainService {
    /**
     * gets all trains DTOs from DB
     *
     * @return trains DTOs
     */
    List<TrainDto> getAllTrains();

    /**
     * adds new train to DB
     *
     * @param trainDto train DTO
     */

    public void addNewTrain(TrainDto trainDto);

    /**
     * checks if train goes specific date
     *
     * @param trainId    train number
     * @param travelDate required date
     * @return true if train goes that day
     */
    boolean checkTrainDate(Long trainId, Date travelDate);

    /**
     * removes train from DB
     *
     * @param id train id to be removed
     */
    void removeTrain(Long id);

    /**
     * provides train entity based on train number
     *
     * @param id train number
     * @return train entity
     */
    Train getTrainByTrainId(Long id);

    /**
     * provides train DTO by it's ID
     *
     * @param id train number
     * @return train DTO
     */
    TrainDto getTrainById(Long id);

    /**
     * removes trains from initial list that do not go required date
     *
     * @param trainsInfo all trains list
     * @param date       required date
     * @return trains that go that day
     */
    List<TrainsAttribute> filterTrainsByDate(List<TrainsAttribute> trainsInfo, Date date);

    HashMap<Long, Long> getCarriages(Long trainId);

    /**
     * adds new train to DB
     *
     * @param trainDto
     * @return true if success
     */
    boolean addNewTrainFromWeb(TrainDto trainDto);

    /**
     * finds train by name
     * @param trainName
     * @return
     */
    Train getTrainByTrainName(String trainName);

    /**
     * deletes train by info from web
     * @param trainDto
     * @return true if success
     */
    boolean deleteTrainFromWeb(TrainDto trainDto);

    /**
     * gets list of cars belonging to train
     * @param trainId
     * @return
     */
    List<Car> getCarsByTrainId(Long trainId);

    /**\
     * find cars number in train by car and train
     * @param trainId
     * @param carId
     * @return number of cars
     */
    Long getCarsNumberByTrainIdCarId(Long trainId, Long carId);

    /**
     * finds total number of sseats in all cars of one type in train by car type and train
     * @param trainId
     * @param carId
     * @return total number of seats
     */
    Long getTotalNumberOfSeats(Long trainId, Long carId);

}
