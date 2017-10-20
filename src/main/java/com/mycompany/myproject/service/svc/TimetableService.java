package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dto.TimetableDto;
import com.mycompany.myproject.service.dto.TrainsAttribute;
import org.joda.time.LocalTime;

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
    ArrayList<Long> getListOfTrainsByStationAndTimePeriod(String stationName, String time1, String time2);

    Long getInitStationByTrainId(Long trainId);
    Long getLastStationByTrainId(Long trainId);
    Time getArrival(Long trainId, Long stationId);
    Time getDeparture(Long trainId, Long stationId);
    boolean checkEnoughTimeBeforeDeparture(Long trainId, Long stationId, LocalTime timeToCheck, Long enoughTime);
}
