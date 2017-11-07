package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.*;
import com.mycompany.myproject.dao.api.StationDao;
import com.mycompany.myproject.dao.api.TimetableDao;
import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.service.svc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImp implements ManagerService {

    @Autowired
    TimetableDao timetableDao;

    @Autowired
    StationDao stationDao;

    @Autowired
    RatesService ratesService;

    @Autowired
    CantonService cantonService;

    @Autowired
    RouteService routeService;

    @Autowired
    SectionService sectionService;
    
    @Autowired
    UserService userService;

    @Autowired
    ReserveSeatService reserveSeatService;

    @Autowired
    StationService stationService;

    @Autowired
    TrainTypeNumberService trainTypeNumberService;

    @Autowired
    TrainService trainService;

    @Autowired
    CarService carService;

    @Autowired
    TrainTypeService trainTypeService;

    @Override
    public List<TrainDto> getTrainsForManagers(){
        List<TrainDto> trains = trainService.getAllTrains();

        for (TrainDto tdto:
             trains) {
            Long initStationId, lastStationId;
            String initStationName, lastStationName;
            Long trainId = tdto.getTrainId();
            Time startTime, finishTime;
            try {
                initStationName = routeService.getInitStationNameOfTrain(trainId);
                initStationId = routeService.getInitStationIdOfTrain(trainId);
                startTime = routeService.getTrainDepartureByStation(initStationId, trainId);
            } catch (IndexOutOfBoundsException e){
                startTime = null;
                initStationName = "--//--";
            }
            try {
                lastStationName = routeService.getLastStationNameOfTrain(trainId);
                lastStationId = routeService.getLastStationIdOfTrain(trainId);
                finishTime = routeService.getTrainArrivalByStation(lastStationId, trainId);

            }
            catch (IndexOutOfBoundsException e) {
                finishTime = null;
                lastStationName = "--//--";
            }

            tdto.setDepartureTime(startTime);
            tdto.setArrivalTime(finishTime);
            tdto.setInitStation(initStationName);
            tdto.setLastStation(lastStationName);
        }
        return trains;
    }


    @Override
    public void addTrainToDB(TrainDto trainDto){
        trainService.addNewTrain(trainDto);
    }

    @Override
    public List<String> getCantonNames() {
        return cantonService.getAllCantonsNames();
    }

    @Override
    public void addStationToDB(StationForm stationForm) {
        stationService.addNewStationByForm(stationForm);
    }

    @Override
    public List<PassengerForm> getPassengers(Long trainNumber, Date travelDate) {
        List <PassengerForm> passengers = new ArrayList<>();

        List <Long> passengersIds = new ArrayList<>();
        for (ReserveSeat reserveSeat:
                reserveSeatService.getAllReserveSeats()) {
            Long trainId = reserveSeat.getTrainId().getTrainId();
            if (trainId==trainNumber){
                Date date = new Date(0L);
                date = reserveSeat.getTravelDate();
                if(date.compareTo(travelDate)==0){
                    if(!passengersIds.contains(reserveSeat.getUserId().getUserId())){
                        passengersIds.add(reserveSeat.getUserId().getUserId());
                    }
                }
            }
        }
        for (Long userId:
                passengersIds) {
            PassengerForm passForm = new PassengerForm();
            User user = userService.getUserById(userId);
            passForm.setFirstName( user.getFirstName());
            passForm.setLastName( user.getLastName());
            passForm.setBirthday(user.getBirthday());
            passengers.add(passForm);
        }
        System.out.println("");
        return passengers;
    }

    @Override
    public List<String> getAllCantonsNames() {
        return cantonService.getAllCantonsNames();
    }

    @Override
    public void addRouteToDB(RouteDto routeDto) {
        Route route = new Route();
        route.setArrival(routeDto.getArrival());
        route.setDeparture(routeDto.getDeparture());
        route.setSection(sectionService.getSectionById(routeDto.getSectionId()));
        route.setTrain(trainService.getTrainByTrainId(routeDto.getTrainId()));
    }

    @Override
    public void addSectionToDB(SectionDto sectionDto) {
        Section section = new Section();
        section.setStationFromId(stationService.getStationById(sectionDto.getStationFromId()));
        section.setStationToId(stationService.getStationById(sectionDto.getStationToId()));
        section.setLength(sectionDto.getLength());


    }

    @Override
    public void addCarToDB(CarDto carDto) {
        Car car = new Car();
        car.setCarPriceRate(carDto.getCarPriceRate());
        car.setCarName(carDto.getCarName());
        car.setSeatsNumber(carDto.getSeatsNumber());
    }

    @Override
    public void addTrainType(TrainTypeDto trainTypeDto) {
        TrainTypeNumber trainTypeNumber = new TrainTypeNumber();
        Long trainTypeNumberId = trainTypeNumberService.add(trainTypeNumber);
        trainTypeDto.setTrainTypeNumber(trainTypeNumberId);
        trainTypeService.addNewTrainType(trainTypeDto);
    }
}
