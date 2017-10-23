package com.mycompany.myproject.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.TimetableDto;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.config.JPAConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class TimetableServiceTest {

    @Autowired
    TimetableService timetableService;

    @Test
    public void testFindAllTimetable() {
        List<TimetableDto> timetableDtos = timetableService.getAllTimetable();
        Assert.assertFalse(timetableDtos.isEmpty());

    }

    @Test
    public void testGetChainOfStations(){
        int stationsInRoute =  timetableService.getChainOfStations(6L, 21L, 22L).size();
        Assert.assertEquals(22L, stationsInRoute);
    }

    @Test
    public void testgetTrainsBetweenStations(){
        List<Long> trainsBetween = timetableService.getTrainsBetweenStations("Bern", "Winterthur");
        Assert.assertEquals(3, trainsBetween.size());
    }
}
