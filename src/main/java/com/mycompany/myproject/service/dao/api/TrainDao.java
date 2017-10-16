package com.mycompany.myproject.service.dao.api;

import com.mycompany.myproject.persist.entity.Train;

import java.util.List;

public interface TrainDao
{
    List<Train> getAllTrains();
    void addNewTrain(Train train);
    void removeTrain(Long id);
    Train getTrainById(Long id);
}
