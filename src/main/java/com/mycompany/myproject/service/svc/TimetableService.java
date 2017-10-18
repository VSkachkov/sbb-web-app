package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dto.TimetableDto;
import com.mycompany.myproject.service.dto.TrainsAttribute;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public interface TimetableService
{

    List<TimetableDto> getAllTimetable();
    List<Timetable> getAllRoutesThroughStationWithId(Long stationId);
    List<TimetableDto> getAllRoutesThroughStationWithName(String stationName);
    List <Long> getListOfTrainsByStation(String stationName);
    List <Long> getTrainsBetweenStations(String stationFrom, String StationTo);
    List<TrainsAttribute> getTimetableBetweenStations(String stationFrom, String stationTo,
                                                      String EarlyTime, String LateTime);
    public ArrayList<Long> getListOfTrainsByStationAndTimePeriod(String stationName, String time1, String time2);
}
