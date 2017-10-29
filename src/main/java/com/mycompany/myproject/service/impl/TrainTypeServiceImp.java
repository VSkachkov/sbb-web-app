package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.TrainTypeDao;
import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.service.svc.TrainTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrainTypeServiceImp implements TrainTypeService {


    @Autowired
    TrainTypeDao trainTypeDao;

    @Override
    public List<TrainTypeDto> getTrainTypeInfo(Long trainTypeId){
        List<TrainTypeDto> trainTypeDtos = new ArrayList<>();

        List <TrainType> trainTypes = trainTypeDao.getTrainTypeInfo(trainTypeId);

        for (TrainType trainType:
             trainTypes) {
            trainTypeDtos.add(new TrainTypeDto(trainType));
        }
    return trainTypeDtos;
    }

    @Override
    public List<TrainTypeDto> getAllTrainTypes() {
        List <TrainTypeDto> trainTypeDtos = new ArrayList<>();
        for (TrainType trainType:
        trainTypeDao.getAllTrainTypes()) {
            trainTypeDtos.add(new TrainTypeDto(trainType));
        }

        return trainTypeDtos;
    }

    @Override
    public void addNewTrainType(TrainTypeDto trainTypeDto) {

    }
}