package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.persist.entity.Station;

import java.util.List;

public interface StationDao {
    List<Station> getAllStations();
    void addNewStation(Station station);
    void removeStation(Long id);
    Station getStationById(Long id);
    Station getStationByName(String name);

    void updateStation(StationDto stationDto);
}
