package com.mycompany.myproject.service;


import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.service.svc.RatesService;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import org.joda.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class RatesServiceTest {

    @Autowired
    RatesService ratesService;

    @Test
    public void testGetRateAgeByUser(){
        float userAgeRate = ratesService.getRateAgeByUser(4L);
        boolean result;
        if (Math.abs(userAgeRate - 0.75) < 0.00001)
            result = true;
        else result=false;
        Assert.assertTrue(result);
    }

    @Test
    public void testGetRateDaysBeforeByTravelDate(){
//        java.sql.Date now = new java.sql.Date( new java.util.Date().getTime());
//        java.sql.Date travelDate = new java.sql.Date(now.getTime() +5000*24*60*60*1000);

        LocalDate currentDate = new LocalDate();
        LocalDate travelDate = LocalDate.now().plusMonths(3);

        Date sqlTravelDate = new Date(travelDate.toDateTimeAtStartOfDay().getMillis());

        float daysBeforeRate = ratesService.getRateDaysBeforeByTravelDate(sqlTravelDate);
        boolean result;
        System.out.println("Days before rate: "+ daysBeforeRate);
        if (Math.abs(daysBeforeRate - 0.7) < 0.00001)
            result = true;
        else result=false;
        Assert.assertTrue(result);
    }

    @Test
    public void testGetRateSeasonByDate(){
        LocalDate travelDate = new LocalDate(2018, 8, 05);
        Date sqlTravelDate = new Date(travelDate.toDateTimeAtStartOfDay().getMillis());
        float seasonRate = ratesService.getRateSeasonByDate(sqlTravelDate);
        boolean result;
        if (Math.abs(seasonRate - 1.1) < 0.00001)
            result = true;
        else result=false;
        Assert.assertTrue(result);

    }

    @Test
    public void testGetRateSeatsLeft(){
        int total = 560;
        int occupied = 400;
        float rateOccupancy = ratesService.getRateSeatsLeft(occupied, total);
        boolean result;
        if (Math.abs(rateOccupancy - 1) < 0.00001)
            result = true;
        else result=false;
        Assert.assertTrue(result);

    }

    @Test
    public void testCalculateTotalRate(){
        LocalDate travelDate = new LocalDate(2018, 8, 05);
        Date sqlTravelDate = new Date(travelDate.toDateTimeAtStartOfDay().getMillis());

        LocalDate bDate = new LocalDate(2010, 8, 05);
        Date sqlBDate = new Date(bDate.toDateTimeAtStartOfDay().getMillis());

        float totalRate = ratesService.calculateTotalRate(sqlBDate, sqlTravelDate, 40, 500);

        boolean result;
        if ((totalRate > 0.7) && (totalRate<1.2))
            result = true;
        else result=false;
        Assert.assertTrue(result);

    }

}