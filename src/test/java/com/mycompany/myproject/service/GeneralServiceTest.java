package com.mycompany.myproject.service;


import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.service.svc.GeneralService;
import com.mycompany.myproject.service.svc.ReserveService;
import com.mycompany.myproject.service.svc.RouteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class GeneralServiceTest {

    @Autowired
    GeneralService generalService;

    @Autowired
    RouteService routeService;

    @Autowired
    ReserveService reserveService;

    @Test
    public void testGetTrainDtosViaStation(){
        List <TrainDto> trainDtos = generalService.getTrainDtosViaStation(13L);
        Assert.assertTrue(!trainDtos.isEmpty());
    }

    @Test
    public void testGetTrainDtosViaStationAndDate(){
        Date date = reserveService.getReserveById(1L).getTravelDate();
        date.setDate(date.getDate()-1);
        Date travelDate = new Date(Calendar.getInstance().getTime().getTime());
        List<TrainDto> trainDtos = generalService
                .getTrainDtosViaStationAndDate(13L, travelDate);
        Assert.assertTrue(!trainDtos.isEmpty());
    }

    @Test
    public void testFindTrainsBetweenStations(){
        List <Long> commonTrains = generalService.findTrainsBetweenStations(13L, 41L);
        Assert.assertTrue(!commonTrains.isEmpty());
    }

    @Test
    public void testFindTrainsFromStationToStation(){
        List <Long> trainsFromOnToTwo = generalService.findTrainsFromStationToStation(3L, 13L);
        Assert.assertTrue(!trainsFromOnToTwo.isEmpty());
    }


    @Test
    public void testGetTrainInfoFromOneStationToOther()
    {
        TrainDto trainDto = generalService.getTrainInfoFromOneStationToOther(9L, 13L, 1L);
        Assert.assertTrue(trainDto != null);
    }

    @Test
    public void testFindTrainDtosFromOneToAnotherStation(){
        List <TrainDto> trainDtos = generalService.findTrainDtosFromOneToAnotherStation(9L, 13L);
        Assert.assertTrue(!trainDtos.isEmpty());
    }

    @Test
    public void testFindTrainDtosFromOneToAnotherStationWithDate(){
        List <TrainDto> trainDtos =
                generalService
                        .findTrainDtosFromOneToAnotherStationWithDate(9L, 13L, new Date(2017, 11, 02));
        Assert.assertTrue(!trainDtos.isEmpty());

    }
}
