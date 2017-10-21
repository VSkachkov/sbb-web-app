package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.service.dao.api.StationDao;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.*;
import com.mycompany.myproject.service.svc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImp implements ManagerService {

    @Autowired
    TimetableDao timetableDao;

    @Autowired
    StationDao stationDao;

    @Autowired
    CantonService cantonService;

    @Autowired
    ReserveSeatService reserveSeatService;

    @Autowired
    StationService stationService;


    @Autowired
    TrainService trainService;

    @Override
    public List<TrainDto> getTrainsForManagers(){ //TODO change implementantion VIA JOIN
        List<TrainDto> trains = trainService.getAllTrains();

        for (TrainDto tdto:
             trains) {
            Long initStationId, lastStationId;
            String initStationName, lastStationName;
            Long trainId = tdto.getTrainId();
            Time startTime, finishTime;
            try {
                initStationId = timetableDao.getInitStationByTrain(trainId);
                startTime = timetableDao.getDeparture(trainId, initStationId);
                initStationName = stationDao.getStationById(initStationId).getStationName();

            } catch (IndexOutOfBoundsException e){
                startTime = null;
                initStationName = "--//--";
            }
            try {

                lastStationId = timetableDao.getLastStationByTrain(trainId);
                finishTime = timetableDao.getArrival(trainId, lastStationId);
                lastStationName = stationDao.getStationById(lastStationId).getStationName();
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
        reserveSeatService.getReserves(trainNumber, travelDate);
        return null;
    }
}
