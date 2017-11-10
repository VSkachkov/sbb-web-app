package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.TrainChangeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class TrainChangeServiceTest {

    @Autowired
    TrainChangeService trainChangeService;

    @Test
    public void testGetChangeById(){
        TrainChange change = trainChangeService.getChangeById(1L);
        Assert.assertTrue(change!=null);
    }

    @Test
    public void testGetChangeByTrainIdAndDate(){
        Date date = trainChangeService.getDateChangeById(1L);
        TrainChange change  = trainChangeService.getChangeByTrainIdAndDate(1L, date);
        Assert.assertTrue(change!=null);
    }

    @Test
    public void testGetStatusChangeById(){
        String status = trainChangeService.getStatusChangeById(1L);
        Assert.assertTrue(status.equals("Cancelled"));
    }

    @Test
    public void testUpdateStatusByChangeId(){
        String status = "Postponed";
        trainChangeService.updateStatusByChangeId(2L, status);
        String newStatus = trainChangeService.getStatusChangeById(2L);
        Assert.assertTrue(newStatus.equals("Postponed"));
    }
}
