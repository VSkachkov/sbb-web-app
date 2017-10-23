package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.dto.TimetableDto;
import com.mycompany.myproject.dto.TrainsAttribute;
import org.joda.time.LocalTime;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public interface TimetableService
{

    /**
     * extracts all timetable information as DTO objects
     * @return timetable DTO
     */
    List<TimetableDto> getAllTimetable();

    /**
     *  gets list of Timetable entities for station based on its ID
     * @param stationId station Id
     * @return Timetable information entities
     */
    List<Timetable> getAllRoutesThroughStationWithId(Long stationId);

    /**
     * provides list of DTO timetable objects for specific train
     * @param trainId train Id
     * @return timetable DTO for train ID
     */
    List<TimetableDto> getRouteOfTrain(Long trainId);

    /**
     * provides all trains information based on station name
     * @param stationName Unique station name
     * @return list of timetable DTOs for this station
     */
    List<TimetableDto> getAllRoutesThroughStationWithName(String stationName);

    /**
     * gets list of trains through station
     * @param stationName unique station name
     * @return list of trains IDs
     */
    List <Long> getListOfTrainsByStation(String stationName);

    /**
     * finds train that go from one station to another
     * @param stationFrom departure station name
     * @param StationTo arrival station name
     * @return list of train IDs
     */
    List <Long> getTrainsBetweenStations(String stationFrom, String StationTo);

    /**
     * find trains between stations within required time perion
     * @param stationFrom deaprture station name
     * @param stationTo arrival station name
     * @param EarlyTime not earlier than time
     * @param LateTime non laer tran time
     * @return list of train DTOs
     */
    List<TrainsAttribute> getTimetableBetweenStations(String stationFrom, String stationTo,
                                                      String EarlyTime, String LateTime);

    /**
     * finds trains for station within required time period
     * @param stationName station name
     * @param time1 not later than time
     * @param time2 not earlier than time
     * @return list of trains IDs
     */
    ArrayList<Long> getListOfTrainsByStationAndTimePeriod(String stationName, String time1, String time2);

    /**
     * finds station ID where train starts
     * @param trainId train number
     * @return station ID
     */
    Long getInitStationByTrainId(Long trainId);

    /**
     * find station ID where train finished it's route
     * @param trainId train number
     * @return station ID
     */
    Long getLastStationByTrainId(Long trainId);

    /**
     * gets arrival time for train and station
     * @param trainId train number
     * @param stationId station id
     * @return time of arrival
     */
    Time getArrival(Long trainId, Long stationId);

    /**
     * gets departure time for train and station
     * @param trainId train number
     * @param stationId statoin ID
     * @return time when train departs from this station
     */
    Time getDeparture(Long trainId, Long stationId);

    /**checks if there is enough time for passenger to buy ticket
     *
     * @param trainId train number
     * @param stationId station number
     * @param timeToCheck time between current time and enough time
     * @param enoughTime time perion that is treated as 'enough time'
     * @return true if time is enough for buying
     */
    boolean checkEnoughTimeBeforeDeparture(Long trainId, Long stationId, LocalTime timeToCheck, Long enoughTime);

    /**
     * gets list of station ID that train passes on it's way
     * @param trainId train number
     * @param departureStation departure station ID
     * @param arrivalStation arrival station id
     * @return ordere list of station that train passes
     */
    List<Long> getChainOfStations(Long trainId, Long departureStation, Long arrivalStation);

    /**
     * extracts stations names from DB
     * @return stations names
     */
    List<String> getAllStationsNames();
}
