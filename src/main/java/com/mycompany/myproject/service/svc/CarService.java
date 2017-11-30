package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.CantonDto;
import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.dto.CarTicketFormDto;
import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.persist.entity.Car;

import java.util.List;


public interface CarService //extends GenericService<Canton, CantonDto_OBSOLETE, Long>
{
    /**
     * extracts carriages DTOs from DB
     *
     * @return carDtos
     */
    List<CarDto> getAllCars();

    /**
     * adds new Car entity to DB
     * @param car
     */
    void addNewCar(Car car);


    /**
     * removes Car from DB
     * @param id  Car ID
     */
    void removeCar(Long id);

    /**
     * extracts Car by it's ID and converts it to DTO
     * @param id
     * @return
     */
    CarDto getCarDtoById(Long id);

    /**
     * extracts Carriage by it's Id
     * @param id Car ID
     * @return
     */
    Car getCarById(Long id);

    /**
     * extracts Car entity from DB by it's name
     * @param s car Name
     * @return
     */
    Car getCarByName(String s);

    /**
     * saves car to DB based on DTO infromation
     * @param carDto - car DTO to Save
     * @return true if success
     */
    boolean saveCarToDb(CarDto carDto);

    /**
     * deletss Car from DB using DTO information
     * @param carDto DTO to delete
     * @return true if success
     */
    boolean deleteCarFromDB(CarDto carDto);

    /**
     * updates car's row in DB
     * @param carId ID to update
     * @param carName  name of car
     * @param seatsNumber number of seats in car
     * @param rate price rate
     */
    void updateCar(Long carId, String carName, Long seatsNumber, float rate);

    /**
     * finds car ticket by car id in list of car tickets
     * @param carTickets car tickets
     * @param carId car ID
     * @return car ticket with required car id
     */
    CarTicketFormDto findCarTicketByCarId(List<CarTicketFormDto> carTickets, Long carId);
}

