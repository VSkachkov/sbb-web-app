package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.TrainTypeDao;
import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import com.mycompany.myproject.service.svc.CarService;
import com.mycompany.myproject.service.svc.TrainTypeNumberService;
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

    @Autowired
    CarService carService;

    @Autowired
    TrainTypeNumberService trainTypeNumberService;

    @Override
    public List<TrainTypeDto> getTrainTypeInfo(Long trainTypeId) {
        List<TrainTypeDto> trainTypeDtos = new ArrayList<>();

        List<TrainType> trainTypes = trainTypeDao.getTrainTypeInfo(trainTypeId);

        for (TrainType trainType :
                trainTypes) {
            trainTypeDtos.add(new TrainTypeDto(trainType));
        }
        return trainTypeDtos;
    }

    @Override
    public List<TrainTypeDto> getAllTrainTypes() {
        List<TrainTypeDto> trainTypeDtos = new ArrayList<>();
        for (TrainType trainType :
                trainTypeDao.getAllTrainTypes()) {
            trainTypeDtos.add(new TrainTypeDto(trainType));
        }

        return trainTypeDtos;
    }

    @Override
    public boolean addNewTrainType(TrainTypeDto trainTypeDto) {
        String typeName = trainTypeDto.getTrainTypeName();
        Long typeNumber = trainTypeDto.getTrainTypeNumber();
        if ((typeName == null || typeName.equals(""))&& (typeNumber==null||typeNumber==0))
            return false;
        Long carId = trainTypeDto.getCarId();
        Long carNumber = trainTypeDto.getNumberOfCars();
        if (carNumber < 1L) return false;
        if (carService.getCarById(carId) == null) return false;
        if (trainTypeNumberService.getTrainTypeNumberById(typeNumber) == null) {
            TrainTypeNumber trainTypeNumber = new TrainTypeNumber();
//            trainTypeNumber.setTrainTypeNumberId(typeNumber);
            trainTypeNumber.setTrainTypeName(typeName);
            trainTypeNumberService.add(trainTypeNumber);
            trainTypeNumber = trainTypeNumberService.getTrainTypeByName(typeName);
            addNerTrainTypeByParams(trainTypeNumber.getTrainTypeNumberId(), carId, carNumber);
        } else {
            addNerTrainTypeByParams(typeNumber, carId, carNumber);
        }
        return true;
    }


    @Override
    public void addNerTrainTypeByParams(Long typeNumber, Long carId, long carNumber) {
        TrainType trainType = new TrainType();
        trainType.setTrainTypeNumber(trainTypeNumberService.getTrainTypeNumberById(typeNumber));
        trainType.setCar(carService.getCarById(carId));
        trainType.setNumberOfCars(carNumber);
        trainTypeDao.addNewTrainType(trainType);
    }

    @Override
    public TrainType getCarByTypeNumberAndCar(TrainTypeNumber trainTypeNumber, Car car) {
        return trainTypeDao.getCarByTypeNumberAndCar(trainTypeNumber, car);
    }
}
