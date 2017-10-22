package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.dao.api.TimetableDao;
import com.mycompany.myproject.dto.TimetableDto;
import com.mycompany.myproject.dto.TrainsAttribute;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.util.CustomTimeConverter;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class TimetableServiceImpl //extends GenericServiceImpl<Timetable,TimetableDto, Long>
        implements TimetableService {
    private static final Logger logger = LoggerFactory.getLogger(TimetableServiceImpl.class);


    @Autowired
    StationService stationService;
    @Autowired
    private TimetableDao timetableDao;

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
    public List<TimetableDto> getRouteOfTrain(Long trainId) {


        List<TimetableDto> tdto = new ArrayList<>();
        for (Timetable timetable:
                timetableDao.getAllRouteOfTrain(trainId)) {
            tdto.add(new TimetableDto(timetable));
        }
        return tdto;
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

//    @Override
//    public List<String> getStationsFromTimetable() {
//         List<TimetableDto> timetable = getAllTimetable();
//         List<String> stationsWithTrains = new ArrayList<>();
//
//        for (TimetableDto oneElementInTimetable:
//             timetable) {
//            if(!stationsWithTrains.contains())
//                stationsWithTrains.add
//        }
//
//    }

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

    public ArrayList <Long> getListOfTrainsByStationAndTimePeriod(String stationName, String time1, String time2){
//    public ArrayList <Long> getListOfTrainsByStationAndTimePeriod(String stationName, Time time1, Time time2){
        ArrayList<Long> trainsList = new ArrayList<>();
        CustomTimeConverter myTimeConverter = new CustomTimeConverter();
        Time t1 = new Time(0L);
        Time t2 = new Time(0L);
        try {
            t1 = myTimeConverter.convertFromDString(time1);
        }
        catch (ParseException e){
            try{
                t1 = myTimeConverter.convertFromDString("0000");
            } catch (ParseException e2){

            }
        }
        try {
            t2 = myTimeConverter.convertFromDString(time2);
        }
        catch (ParseException e){
            try{
                t2 = myTimeConverter.convertFromDString("2359");
            } catch (ParseException e2){
            }
        }
        for (Timetable timetable:
                timetableDao.getTrainsViaStationWithTime(stationName, t1, t2)) {
            trainsList.add(timetable.getTrain().getTrainId());
        }
        return trainsList;
    }


    @Override
    public Long getInitStationByTrainId(Long trainId) {
        return timetableDao.getInitStationByTrain(trainId);
    }

    @Override //TODO Implement methhod
    public Long getLastStationByTrainId(Long trainId) {
        return timetableDao.getLastStationByTrain(trainId);
    }

    @Override
    public Time getArrival(Long trainId, Long stationId) {
        return timetableDao.getArrival(trainId, stationId);
    }

    @Override
    public Time getDeparture(Long trainId, Long stationId) {
        return timetableDao.getDeparture(trainId, stationId);
    }

    @Override
    public boolean checkEnoughTimeBeforeDeparture(Long trainId, Long stationId, LocalTime timeToCheck, Long enoughTime) {
        Time departureTime = timetableDao.getDeparture(trainId, stationId);
        Time sqlTimeTocheck = new Time(new LocalTime(timeToCheck).toDateTimeToday().
                withZone(DateTimeZone.forID("Europe/Moscow")).getMillis());
        Time timezone = new java.sql.Time(6, 0, 0); //TODO fix problem with timezone
        long diffInMillies = departureTime.getTime() - sqlTimeTocheck.getTime()-timezone.getTime();

        Time diff = new Time(diffInMillies);
        int h = diff.getHours();
        int m = diff.getMinutes();
        Long result = new Time(h, m, 0).getTime();
        if (result<enoughTime)
            return false;
        else return true;
    }

    @Override
    public List<Long> getChainOfStations(Long trainId, Long departureStation, Long arrivalStation) {
        List<TimetableDto> tdto = this.getRouteOfTrain(trainId);

        Long departureTimeLong = this.getDeparture(trainId, departureStation).getTime();
        Long arrivalTimeLong = this.getArrival(trainId, arrivalStation).getTime();

        List<Long> stations = new ArrayList<>();
        for (TimetableDto timetable:
                tdto) {
                    stations.add(timetable.getStationId());
            }
        int indexFirst = stations.indexOf(departureStation);
        int indexLast = stations.indexOf(arrivalStation);
        List<Long> stationsInRoute = new ArrayList<>();
        for (Long stationIdx:
             stations) {
            if (stations.indexOf(stationIdx)<=indexLast){
                if(stations.indexOf(stationIdx)>=indexFirst){
                    stationsInRoute.add(stationIdx);
                }
            }

        }

        return stationsInRoute;
    }

    @Override
    public List<String> getAllStationsNames() {
        return stationService.getAllStationsNames();
    }

    @Override
    public List <Long> getTrainsBetweenStations(String stationFrom, String StationTo){
        ArrayList <Long> trainsFromStation = getListOfTrainsByStation(stationFrom);
        ArrayList <Long> trainsToStation = getListOfTrainsByStation(StationTo);
        ArrayList<Long> common = new ArrayList<>(trainsFromStation);
        common.retainAll(trainsToStation);
       return common;
    }

    @Override
//    public List<TrainsAttribute> getTimetableBetweenStations(String stationFrom, String stationTo,
//                                                             Time EarlyTime, Time LateTime) {
        public List<TrainsAttribute> getTimetableBetweenStations(String stationFrom, String stationTo,
                String EarlyTime, String LateTime) {
        List<Long> trainsByTime = new ArrayList<>();
//        trainsByTime = getListOfTrainsByStationAndTimePeriod(stationFrom, EarlyTime,LateTime);
        trainsByTime = getListOfTrainsByStationAndTimePeriod(stationFrom, EarlyTime,LateTime);

        List<TrainsAttribute> timetableInfo = new ArrayList<>();
        List<Long> trains = new ArrayList<>();
        trains = getTrainsBetweenStations(stationFrom, stationTo);
        trains.retainAll(trainsByTime);
        for (Long train:
                trains) {
            Long trainId = train;
            Long stToId = stationService.getStationByName(stationTo).getStationId();
            Time arrival = timetableDao.getArrival(train, stToId);
            Long stFromId = stationService.getStationByName(stationFrom).getStationId();
            Time departure = timetableDao.getDeparture(train, stFromId);

            timetableInfo.add(new TrainsAttribute(trainId, stationFrom, departure, stationTo, arrival));
        }
        return timetableInfo;
    }


}
