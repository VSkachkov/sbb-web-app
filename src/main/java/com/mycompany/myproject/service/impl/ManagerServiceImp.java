package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.service.dao.api.StationDao;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.StationDto;
import com.mycompany.myproject.service.dto.TimetableDto;
import com.mycompany.myproject.service.dto.TrainDto;
import com.mycompany.myproject.service.svc.ManagerService;
import com.mycompany.myproject.service.svc.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
