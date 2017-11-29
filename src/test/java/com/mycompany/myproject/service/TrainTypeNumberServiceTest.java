package com.mycompany.myproject.service;


import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import com.mycompany.myproject.service.svc.TrainTypeNumberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class TrainTypeNumberServiceTest {
    @Autowired
    TrainTypeNumberService trainTypeNumberService;

    @Test
    public void testGetAllTrainTypeNumber(){
        Assert.assertTrue(!trainTypeNumberService.getAllTrainTypesNumbers().isEmpty());
    }

    @Test
    public void testGetTrainTypeNumberById(){
        TrainTypeNumber trainTypeNumber = trainTypeNumberService.getTrainTypeNumberById(2L);
        Assert.assertTrue(trainTypeNumber!=null);
    }

    @Test
    public void testAddTrainTypeNumber(){
        TrainTypeNumber trainTypeNumber = new TrainTypeNumber();
        trainTypeNumber.setTrainTypeName("Some train name2");
//        trainTypeNumber.setTrainTypeNumberId(4L);
        trainTypeNumberService.add(trainTypeNumber);
        Assert.assertTrue(trainTypeNumberService.getTrainTypeByName("Some train name2")!=null);
    }

    @Test
    public void testDeleteTrainTypeNumberById(){
//        if(trainTypeNumberService.getTrainTypeNumberById(4L)!=null) {
            trainTypeNumberService.deleteTrainTypeNumberById(4l);
            Assert.assertTrue((trainTypeNumberService.getTrainTypeNumberById(4L)==null));
//            }
//        }
    }

}
