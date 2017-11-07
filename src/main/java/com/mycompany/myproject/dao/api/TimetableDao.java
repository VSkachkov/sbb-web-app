package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Timetable;

import java.sql.Time;
import java.util.List;

public interface TimetableDao {


    List<Timetable> getAllTimetable();
    void addNewTimetable(Timetable timetable);
    void removeTimetable(Long trainId);
    List<Timetable>getAllRouteOfTrain(Long trainId);
    Time getArrival(Long trainId, Long stationId);
    Time getDeparture(Long trainId, Long stationId);
    List<Timetable>getAllRoutesThroughStationId(Long stationId);
    List<Timetable> getAllTrainsThroughStationName(String stationName);
    List<Timetable> getTrainsViaStationWithTime(String stationName, Time earlyTime, Time lateTime);
    Long getInitStationByTrain(Long trainId);
    Long getLastStationByTrain(Long trainId);


}
