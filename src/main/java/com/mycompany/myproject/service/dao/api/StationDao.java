package com.mycompany.myproject.service.dao.api;

import com.mycompany.myproject.persist.entity.Station;

import java.util.List;

public interface StationDao {

    List<Station> getAllStations();
    void addNewStation(Station station);
    void removeStation(Long id);
    Station getStationById(Long id);
    Station getStationByName(String name);
}