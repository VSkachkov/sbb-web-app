package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.TrainChangeDao;
import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.TrainChangeService;
import com.mycompany.myproject.service.svc.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional
public class TrainChangeServiceImp implements TrainChangeService {

    @Autowired
    TrainChangeDao trainChangeDao;

    @Autowired
    TrainService trainService;

    @Override
    public TrainChange getChangeById(Long id) {
        return trainChangeDao.getChangeById(id);
    }

    @Override
    public TrainChange getChangeByTrainDate(Train train, Date date) {
        return trainChangeDao.getChangeByTrainDate(train, date);
    }

    @Override
    public Date getDateChangeById(Long changeId) {
        return trainChangeDao.getDateByChangeId(changeId);
    }

    @Override
    public String getStatusChangeById(Long changeId) {
        return trainChangeDao.getStatusByChangeId(changeId);
    }

    @Override
    public TrainChange getChangeByTrainIdAndDate(Long trainId, Date date) {
        Train train = trainService.getTrainByTrainId(trainId);
        return getChangeByTrainDate(train, date);
    }

    @Override
    public void addTrainChange(TrainChange trainChange) {
        trainChangeDao.addTrainChange(trainChange);
    }

    @Override
    public void updateStatusByChangeId(Long changeId, String newStatus) {
        trainChangeDao.updateStatusByChangeId(changeId,  newStatus);
    }
}
