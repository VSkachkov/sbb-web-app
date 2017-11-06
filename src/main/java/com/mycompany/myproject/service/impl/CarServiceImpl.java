package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.CarDao;
import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.service.svc.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl //extends GenericServiceImpl<Canton,CantonDto_OBSOLETE, Long>
        implements CarService {


    @Autowired
    private CarDao carDao;

    @Override
    public List<CarDto> getAllCars() {
        List<CarDto> cdto = new ArrayList<>();

        for (Car car:
        carDao.getAllCars()) {
            cdto.add(new CarDto(car));
        }

        return cdto;
    }


    @Override
    public void addNewCar(Car car) {
        carDao.addNewCar(car);
    }

    @Override
    public void removeCar(Long id) {
        carDao.removeCar(id);

    }

    @Override
    public CarDto getCarDtoById(Long id) {
        return new CarDto(carDao.getCarById(id));
    }

    @Override
    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }

    @Override
    public Car getCarByName(String s) {
        return carDao.getCarByName(s);
    }

//    @Override
//    public List<String> getAllCarNames() {
//        List<String> carNames  = new ArrayList<>();
//
//        for (Car car:
//                carDao.getAllCars()) {
//            carNames.add(car.getCarName());
//        }
//        return carNames;
//    }

}

