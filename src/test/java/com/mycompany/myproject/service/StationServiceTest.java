package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.service.svc.StationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class StationServiceTest {

    @Autowired
    StationService stationService;

    @Test
    public void testGetAllStationDtos(){
        List<StationDto> stationDtoList = stationService.getAllStationDtos();
        Assert.assertTrue(!stationDtoList.isEmpty());

    }
}
