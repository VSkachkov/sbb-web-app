package com.mycompany.myproject.service.svc;


import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.persist.entity.Station;
//import com.mycompany.myproject.persist.repo.StationRepo;
import com.mycompany.myproject.dto.StationForm;

import java.util.List;


public interface StationService// extends GenericService<Station, StationDto, Long>
{

    /**
     * extracts list of all stations from database
     * @return List of Station entities
     */
    List<Station> getAllStations();

    /**
     * adds new Station entity in database
     * @param station to be added to DB
     */
    void addNewStation(Station station);

    /**
     * removes station from DB based on it's ID
     * @param id of station to be removed
     */
    void removeStation(Long id);

    /**
     * extracts Station entity from database
     * @param id of station
     * @return Station entity
     */
    Station getStationById(Long id);

    /**
     * gets station entity by it's unique name
     * @param name of station
     * @return Station entity
     */
    Station getStationByName(String name);

    /**
     * gets list of all station names from db
     * @return list of station names
     */
    List<String>getAllStationsNames();

    /**
     * adds new station to DB based on the information in form
     * @param stationForm station information
     */
    void addNewStationByForm(StationForm stationForm);

    boolean addNewStationByDto(StationDto stationDto);

    boolean isStationIdInDb(Long stationId);

    boolean isStationNameInDb(String stationName);

    List <StationDto> getAllStationDtos();

    void updateStation(StationDto stationDto);
}
