package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.persist.entity.TrainChange;

import java.sql.Date;

public interface TrainChangeService {
    TrainChange getChangeById(Long id);
    TrainChange getChangeByTrainDate(Train train, Date date);
    Date getDateChangeById(Long changeId);
    String getStatusChangeById(Long changeId);
    TrainChange getChangeByTrainIdAndDate(Long trainId, Date date);
    void addTrainChange(TrainChange trainChange);
    void updateStatusByChangeId(Long changeId, String newStatus);
}
