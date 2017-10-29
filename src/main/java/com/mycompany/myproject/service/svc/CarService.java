package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.CantonDto;
import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.persist.entity.Car;

import java.util.List;


public interface CarService //extends GenericService<Canton, CantonDto_OBSOLETE, Long>
{

    List<CarDto> getAllCars();

    void addNewCar(Car car);


    void removeCar(Long id);

    CarDto getCarById(Long id);

    Car getCarByName(String s);


//    List<String>getAllCarsNames();*/

}

