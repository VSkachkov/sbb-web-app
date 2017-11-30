package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.CarDao;
import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.dto.CarTicketFormDto;
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

    @Override
    public boolean saveCarToDb(CarDto carDto) {
        Long carId = carDto.getCarId();
        String carName = carDto.getCarName();
        Long seatsNumber = carDto.getSeatsNumber();
        float rate = carDto.getCarPriceRate();
        if (carName==null||carName.equals(""))
            return false;
        if (seatsNumber<1||seatsNumber>120||seatsNumber==null)
            return false;
        if(rate<0.1||rate>10)
            return false;
        if(getCarById(carId)==null)
        {
            if (getCarByName(carName)!=null)
                return false;
            else
            {
                Car car = new Car();
                car.setCarName(carName);
                car.setSeatsNumber(seatsNumber);
                car.setCarPriceRate(rate);
                addNewCar(car);
                return true;
            }
        }
        else {
            this.updateCar(carId, carName, seatsNumber, rate);
            return true;
        }

    }

    @Override
    public boolean deleteCarFromDB(CarDto carDto) {

        Long carId = carDto.getCarId();
        if (carId == null )
            return false;
        else
        {
            if(this.getCarById(carId)!=null)
                this.removeCar(carId);
            if(this.getCarById(carId)==null)
                return true;
            else return true;
        }
    }

    @Override
    public void updateCar(Long carId, String carName, Long seatsNumber, float rate) {
        carDao.updateCar(carId, carName, seatsNumber, rate);
    }

    @Override
    public CarTicketFormDto findCarTicketByCarId(List<CarTicketFormDto> carTickets, Long carId) {
        for (CarTicketFormDto carTicket:
             carTickets ) {
            if (carTicket.getCarId()==carId)
                return carTicket;
        }
        return null;
    }

}

