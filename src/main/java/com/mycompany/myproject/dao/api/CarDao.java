package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAllCars();
    void addNewCar(Car car);
    void removeCar(Long id);
    Car getCarById(Long id);
    Car getCarByName(String s);
}
