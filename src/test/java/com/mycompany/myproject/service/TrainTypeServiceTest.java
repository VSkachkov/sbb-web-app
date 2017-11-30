package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dao.api.TrainTypeDao;
import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import com.mycompany.myproject.service.svc.CarService;
import com.mycompany.myproject.service.svc.TrainTypeNumberService;
import com.mycompany.myproject.service.svc.TrainTypeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class TrainTypeServiceTest {
    @Autowired
    TrainTypeService trainTypeService;

    @Autowired
    TrainTypeNumberService trainTypeNumberService;

    @Autowired
    CarService carService;

    @Autowired
    TrainTypeDao trainTypeDao;

    @Test
    public void testGetTrainTypeInfo(){
        List<TrainTypeDto> trainTypeDtoList = trainTypeService.getTrainTypeInfo(1L);
        Assert.assertNotNull(trainTypeDtoList);
    }

    @Test
    public void testGetTrainTypeById(){
        TrainTypeNumber trainTypeNumber= trainTypeDao.getTrainTypeNumberById(1L);
         ;
//        Assert.assertNotNull(trainTypeDao.getAllTrainTypeNumber());
        Assert.assertNotNull(trainTypeNumber);
    }

    @Test
    public void testGetAllTrainTypes(){
        Assert.assertTrue(trainTypeService.getAllTrainTypes()!=null);
    }

    @Test
    public void testAddNewTrainType(){
        TrainTypeDto  trainTypeDto = new TrainTypeDto();
        trainTypeDto.setTrainTypeNumber(1L);
        trainTypeDto.setCarId(4L);
        trainTypeDto.setNumberOfCars(3L);

    }

    @Test
    public void testGetCarByTypeNumberAndCar() {
        TrainTypeNumber trainTypeNumber = trainTypeNumberService.getTrainTypeNumberById(1L);
        Car car = carService.getCarById(1L);
        TrainType trainType = trainTypeService.getCarByTypeNumberAndCar(trainTypeNumber, car);
        Assert.assertTrue(trainType != null);
    }

}


