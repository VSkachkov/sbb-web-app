package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dao.api.TrainTypeDao;
import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
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

}


