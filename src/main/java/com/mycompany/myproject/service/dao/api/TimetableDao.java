package com.mycompany.myproject.service.dao.api;

import com.mycompany.myproject.persist.entity.Timetable;

import java.util.List;

public interface TimetableDao {


    List<Timetable> getAllTimetable();
    void addNewTimetable(Timetable timetable);
    void removeTimetable(Long trainId);
    List<Timetable>getAllRouteOfTrain(Long trainId);
    List<Timetable>getAllRoutesThroughStationId(Long stationId);
    List<Timetable>getAllRoutesThroughStationName(String stationName);

//
//    List<Station> getAllStations();
//    void addNewStation(Station canton);
//    void removeStation(Long id);
//    Station getStationById(Long id);
//    Station getStationByName(String name);

}
