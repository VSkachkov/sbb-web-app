package com.mycompany.myproject.service;

import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.service.svc.ManagerService;
import com.mycompany.myproject.service.svc.TrainTypeNumberService;
import com.mycompany.myproject.service.svc.TrainTypeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.service.svc.ReserveSeatService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class ManagerServiceTest {

    @Autowired
    ManagerService managerService;

    @Autowired
    TrainTypeNumberService trainTypeNumberService;

    @Autowired
    TrainTypeService trainTypeService;

    @Test
    public void testGetTrainsForManagers(){
        List<TrainDto> trainsInDb = managerService.getTrainsForManagers();
        Assert.assertFalse(trainsInDb.isEmpty());
    }

    @Test
    public void testAddTrainType(){
        TrainTypeDto trainTypeDto = new TrainTypeDto();
        trainTypeDto.setTrainTypeNumber(3L);
        trainTypeDto.setCarId(2L);
        trainTypeDto.setNumberOfCars(7L);
        trainTypeDto.setTrainTypeName("Some train");
        managerService.addTrainType(trainTypeDto);
        Assert.assertTrue(!trainTypeService.getTrainTypeInfo(3L).isEmpty());
//        Assert.assertTrue(trainTypeNumberService.getTrainTypeNumberById(3L)!=null);
    }


}
