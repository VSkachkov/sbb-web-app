package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.TimetableDto;
import com.mycompany.myproject.service.dto.TrainsAttribute;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


//
//@Service
//@Transactional
//public class TimetableServiceImpl implements TimetableService {
//
//
//    @Autowired
//    TimetableDao timetableDao;
//    @Override
//    public List<TimetableDto> getAllTimetable() {
//        List<TimetableDto> sdto = new ArrayList<>();
//
//        for (Timetable timetable :
//                timetableDao.getAllTimetable()) {
//            sdto.add(new TimetableDto(timetable));
//        }
//        return sdto;
//    }
//
//    @Override
//    public List<Timetable> getAllRoutesThroughStationWithId(Long stationId) {
//        return null;
//    }
//
//    @Override
//    public List<TimetableDto> getAllRoutesThroughStationWithName(String stationName) {
//        return null;
//    }
//}
//


@Service
@Transactional
public class TimetableServiceImpl //extends GenericServiceImpl<Timetable,TimetableDto, Long>
        implements TimetableService {
    private static final Logger logger = LoggerFactory.getLogger(TimetableServiceImpl.class);

    @Autowired
    StationService stationservice;
    @Autowired
    private TimetableDao timetableDao;

    //    @Override
    //    public List<TimetableDto> getAllTimetable() {
    //        List <TimetableDto> ltdto = new ArrayList<TimetableDto>();
    //        timetableDao.getAllTimetable()
    //                .stream().forEachOrdered(ae -> ltdto.add(new TimetableDto(ae)));
    //        return ltdto;
    //    }

    @Override
    public List<TimetableDto> getAllTimetable() {
        List<TimetableDto> tdto = new ArrayList<>();
        for (Timetable timetable:
                timetableDao.getAllTimetable()) {
            tdto.add(new TimetableDto(timetable));
        }
        return tdto;

    }


    @Override
    public List<Timetable> getAllRoutesThroughStationWithId(Long stationId) {
        return timetableDao.getAllRoutesThroughStationId(stationId);
    }

    @Override
    public List<TimetableDto> getAllRoutesThroughStationWithName(String stationName) {
        List<TimetableDto> tdto = new ArrayList<>();
        for (Timetable timetable:
                timetableDao.getAllTrainsThroughStationName(stationName)) {
            tdto.add(new TimetableDto(timetable));
        }
        return tdto;
    }

    @Override
    public ArrayList <Long> getListOfTrainsByStation(String stationName){
        ArrayList<Long> trainsList = new ArrayList<>();
        for (Timetable timetable:
                timetableDao.getAllTrainsThroughStationName(stationName)) {
            trainsList.add(timetable.getTrain().getTrainId());
        }
        return trainsList;
    }

    @Override
    public List <Long> getTrainsBetweenStations(String stationFrom, String StationTo){
        ArrayList <Long> trainsFromStation = getListOfTrainsByStation(stationFrom);
        ArrayList <Long> trainsToStation = getListOfTrainsByStation(StationTo);
        ArrayList<Long> common = new ArrayList<>(trainsFromStation);
        common.retainAll(trainsToStation);
//        ArrayList<Long> trainsFromAToB = (ArrayList<Long>)trainsFromStation.clone();
//        trainsFromAToB.removeAll((ArrayList<Long>)trainsToStation);
        return common;
    }

    @Override
    public List<TrainsAttribute> getTimetableBetweenStations(String stationFrom, String stationTo,
                                                             String EarlyTime, String LateTime) {
        logger.error("We are in getTimetableBetweenStations method");
        List<TrainsAttribute> timetableInfo = new ArrayList<>();
        List<Long> trains = new ArrayList<>();
        trains = getTrainsBetweenStations(stationFrom, stationTo);
        logger.error("trains List: "+ trains.toString());
        for (Long train:
                trains) {
            Long trainId = train;
            Long stToId = stationservice.getStationByName(stationTo).getStationId();
            Time arrival = timetableDao.getArrival(train, stToId);
            Long stFromId = stationservice.getStationByName(stationFrom).getStationId();
            Time departure = timetableDao.getDeparture(train, stFromId);

            timetableInfo.add(new TrainsAttribute(trainId, stationFrom, departure, stationTo, arrival));
        }
        return timetableInfo;
    }


}
