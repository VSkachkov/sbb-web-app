package com.mycompany.myproject.service;

import com.mycompany.myproject.persist.entity.ReserveSeat;
import com.mycompany.myproject.service.svc.ReserveSeatService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.TimetableDto;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.config.JPAConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class ReserveSeatServiceTest {

    @Autowired
    ReserveSeatService reserveSeatService;

   @Test
    public void testIsPassengerOnboard(){
       List <Long> stations = new ArrayList<>();
       stations.add(2L);
       Assert.assertFalse(reserveSeatService.isPassengerOnboard(1L, stations, new java.sql.Date(0L), 1L));
    }

}
