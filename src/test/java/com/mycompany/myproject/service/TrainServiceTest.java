package com.mycompany.myproject.service;


import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.service.svc.TrainService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class TrainServiceTest {

    @Autowired
    TrainService trainService;

    @Test
    public void testGetAllTrains(){
        Assert.assertTrue(!trainService.getAllTrains().isEmpty());
    }

    @Test
    public void testGetTrainById(){
        TrainDto trainDto = new TrainDto();
        trainDto = trainService.getTrainById(1L);
        Assert.assertTrue(trainDto.isDepartFri());
    }

    @Test
    public void testGetCarriages(){
        HashMap<Long, Long> cars = trainService.getCarriages(2L);
        Assert.assertTrue(!cars.isEmpty());
    }


}
