package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.persist.entity.TrainChange;

import java.sql.Date;

public interface TrainChangeDao {
    TrainChange getChangeById(Long id);
    TrainChange getChangeByTrainDate(Train train, Date date);
    Date getDateByChangeId(Long id);
    String getStatusByChangeId(Long changeId);
    void addTrainChange(TrainChange trainChange);
    void updateStatus(Train train, Date date, String newStatus);
    void updateStatusByChangeId(Long changeId, String newStatus);
}
