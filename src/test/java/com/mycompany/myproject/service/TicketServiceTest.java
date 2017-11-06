package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.service.svc.TicketService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class TicketServiceTest {

    @Autowired
    TicketService ticketService;


    @Test
    public void testCheckDateValidity(){
        boolean result;
        java.sql.Date travelDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        result = ticketService.checkDateValidity(travelDate);
        Assert.assertTrue(result);
        travelDate.setMonth(travelDate.getMonth()-1);
        result = ticketService.checkDateValidity(travelDate);
        Assert.assertFalse(result);
        travelDate.setMonth(travelDate.getMonth()+2);
        result = ticketService.checkDateValidity(travelDate);
        Assert.assertTrue(result);

    }

    @Test
    public void testCheckEnoughTimeBeforeDeparture(){
        boolean result; //THIS TEST IS FOR CURRENT TIME 19.39
        result = ticketService.checkEnoughTimeBeforeDeparture(2L, 9L);
        Assert.assertTrue(result);

        result = ticketService.checkEnoughTimeBeforeDeparture(1L, 9L);
        Assert.assertFalse(result);
    }
}
