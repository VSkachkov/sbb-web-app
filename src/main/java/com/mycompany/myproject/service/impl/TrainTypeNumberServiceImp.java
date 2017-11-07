package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.TrainTypeNumberDao;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import com.mycompany.myproject.service.svc.TrainTypeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainTypeNumberServiceImp implements TrainTypeNumberService {

    @Autowired
    TrainTypeNumberDao trainTypeNumberDao;

    @Override
    public List<TrainTypeNumber> getAllTrainTypesNumbers(){
        return trainTypeNumberDao.getAllTrainTypeNumbers();
    }

    @Override
    public Long add(TrainTypeNumber trainTypeNumber) {
        return trainTypeNumberDao.add(trainTypeNumber);
    }

    @Override
    public TrainTypeNumber getTrainTypeNumberById(Long trainTypeNumberId) {
        return trainTypeNumberDao.getTrainTypeNumberById(trainTypeNumberId);
    }

    public List<TrainType> getTrainTypeByTrainTypeNumber(Long trainTypeNumberId){
        return null;
//        return trainTypeNumberDao.getTrainTypeById(trainTypeNumberId);
    }

}
