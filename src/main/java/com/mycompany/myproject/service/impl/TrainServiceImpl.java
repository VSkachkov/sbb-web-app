package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.dto.TrainTypeDto;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.dao.api.TrainDao;
import com.mycompany.myproject.dto.TrainDto;
//import com.mycompany.myproject.service.impl.GenericServiceImpl;
import com.mycompany.myproject.dto.TrainsAttribute;
import com.mycompany.myproject.persist.entity.TrainType;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import com.mycompany.myproject.service.svc.CarService;
import com.mycompany.myproject.service.svc.TrainService;
import com.mycompany.myproject.service.svc.TrainTypeNumberService;
import com.mycompany.myproject.service.svc.TrainTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class TrainServiceImpl  implements TrainService {
    final int SUN = 1;
    final int MON = 2;
    final int TUE = 3;
    final int WED = 4;
    final int THU = 5;
    final int FRI = 6;
    final int SAT = 7;



    @Autowired
    TrainDao trainDao;

    @Autowired
    TrainTypeService trainTypeService;

    @Autowired
    TrainTypeNumberService trainTypeNumberService;

    @Autowired
    CarService carService;

    @Override
    public List<TrainDto> getAllTrains() {
        List<TrainDto> sdto = new ArrayList<>();

        for (Train train :
                trainDao.getAllTrains()) {
            sdto.add(new TrainDto(train));
        }
        return sdto;
    }

    @Override
    public void addNewTrain(TrainDto trainDto) {
        Train train = new Train();
        train.setTrainName(trainDto.getTrainName());
        train.setDepartMon(trainDto.isDepartMon());
        train.setDepartTue(trainDto.isDepartTue());
        train.setDepartWed(trainDto.isDepartWed());
        train.setDepartThu(trainDto.isDepartThu());
        train.setDepartFri(trainDto.isDepartFri());
        train.setDepartSat(trainDto.isDepartSat());
        train.setDepartSun(trainDto.isDepartSun());
        train.setTrainTypeNumber(trainTypeNumberService.getTrainTypeNumberById(trainDto.getTrainTypeNumber()));
        trainDao.addNewTrain(train);

    }

    @Override
    public boolean checkTrainDate(Long trainId, Date travelDate) {
        TrainDto trainDto = getTrainById(trainId);
        Calendar c = Calendar.getInstance();
        c.setTime(travelDate);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch(dayOfWeek) {
            case MON:
                return trainDto.isDepartMon();
            case TUE:
                return trainDto.isDepartTue();
            case WED:
                return trainDto.isDepartWed();
            case THU:
                return trainDto.isDepartThu();
            case FRI:
                return trainDto.isDepartFri();
            case SAT:
                return trainDto.isDepartSat();
            case SUN:
                return trainDto.isDepartSun();
            default:
                return false;
        }
    }

    @Override
    public void removeTrain(Long id) {
        trainDao.removeTrain(id);
    }

    @Override
    public Train getTrainByTrainId(Long id) {
        return trainDao.getTrainById(id);
    }

    @Override
    public Train getTrainByTrainName(String trainName) {
        return trainDao.getTrainByName(trainName);
    }

    @Override
    public boolean deleteTrainFromWeb(TrainDto trainDto) {
        Long trainId = trainDto.getTrainId();
        if (this.getTrainById(trainId)==null)
            return false;
        else trainDao.removeTrain(trainId);
        return true;
    }

    @Override
    public List<Car> getCarsByTrainId(Long trainId) {
        Train train = this.getTrainByTrainId(trainId);
        List <TrainTypeDto> trainTypeDtos = trainTypeService.
                getTrainTypeInfo(train.getTrainTypeNumber().getTrainTypeNumberId());
        List<Long> carIds = new ArrayList<>();
        for (TrainTypeDto trainTypeDto :
                trainTypeDtos) {
            carIds.add(trainTypeDto.getCarId());
        }
        List <Car> cars = new ArrayList<>();
        for (Long carId :
                carIds) {
            Car car = carService.getCarById(carId);
            cars.add(car);
        }
        return cars;
    }

    @Override
    public Long getCarsNumberByTrainIdCarId(Long trainId, Long carId){
        TrainTypeNumber trainTypeNumber = this.getTrainByTrainId(trainId).getTrainTypeNumber();
        Car car = carService.getCarById(carId);
        TrainType trainType = trainTypeService.getCarByTypeNumberAndCar(trainTypeNumber, car);
        return trainType.getNumberOfCars();
    }

    @Override
    public Long getTotalNumberOfSeats(Long trainId, Long carId){
        Long carsNumber = getCarsNumberByTrainIdCarId(trainId, carId);
        Long seatsNumber = carService.getCarById(carId).getSeatsNumber();
        return carsNumber*seatsNumber;
    }

    @Override
    public TrainDto getTrainById(Long trainId) {
        Train train = trainDao.getTrainById(trainId);
        TrainDto trainDto = new TrainDto(train);
        Long trainTypeNumber = trainDto.getTrainTypeNumber();
        List <TrainTypeDto> trainTypeDtos = trainTypeService.getTrainTypeInfo(trainTypeNumber);
        trainDto.setTrainTypeDtos(trainTypeDtos);
        return trainDto;
    }

    @Override
    public List<TrainsAttribute> filterTrainsByDate(List<TrainsAttribute> trainsInfo, Date date) {
    List<TrainsAttribute> filteredTrainsList = new ArrayList<>();

        for (TrainsAttribute trainInfo:
             trainsInfo) {
            if(checkTrainDate(trainInfo.getTrainId(), date)){
                filteredTrainsList.add(trainInfo);
            }
        }
        return filteredTrainsList;
    }
    
    @Override
    public HashMap<Long, Long> getCarriages(Long trainId){
        HashMap<Long, Long> carriages = new HashMap<>();
        Train train = this.getTrainByTrainId(trainId);
        TrainTypeNumber typeNumber = train.getTrainTypeNumber();
        Long typeNumberId = typeNumber.getTrainTypeNumberId();
        List <TrainTypeDto> typeDtos = trainTypeService.getTrainTypeInfo(typeNumberId);

        for (TrainTypeDto typeDto :
             typeDtos) {
            Long carId = typeDto.getCarId();
            Long numberOfCars = typeDto.getNumberOfCars();
            carriages.put(carId, numberOfCars);
        }
        return carriages;
    }

    @Override
    public boolean addNewTrainFromWeb(TrainDto trainDto) {
        Long trainTypeNumber = trainDto.getTrainTypeNumber();
        String trainName = trainDto.getTrainName();
        if(this.getTrainByTrainName(trainName)!=null)
            return false;
        if(trainTypeNumber==null)
            return false;
        this.addNewTrain(trainDto);
        return true;

    }
}
