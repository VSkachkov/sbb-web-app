package com.mycompany.myproject.service;

import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.service.svc.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class CarServiceTest {

    @Autowired
    CarService carService;

    @Test
    public void testGetAllCars(){
        List<CarDto> cars = carService.getAllCars();
        Assert.assertFalse(cars.isEmpty());
    }

    @Test
    public void testAddNewCar(){
        Car car = new Car();
        car.setCarName("Giruno 2nd class");
        car.setCarPriceRate(1);
        car.setSeatsNumber(36L);

        carService.addNewCar(car);
        Assert.assertEquals(2L, carService.getCarByName("Giruno 2nd class").getCarId().longValue());

    }

    @Test
    public void testGetCarByName()
    {
        Assert.assertEquals(2L, carService.getCarByName("Giruno 2nd class").getCarId().longValue());
    }


}
