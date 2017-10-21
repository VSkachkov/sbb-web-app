package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.service.dao.api.StationDao;
import com.mycompany.myproject.service.dto.StationForm;
import com.mycompany.myproject.service.svc.CantonService;
import com.mycompany.myproject.service.svc.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StationServiceImpl
        implements StationService {

    @Autowired
    private StationDao stationDao;

    @Autowired
    CantonService cantonService;

    @Override
    public List<Station> getAllStations() {
        return stationDao.getAllStations();
    }

    @Override
    public void addNewStation(Station station) {
        stationDao.addNewStation(station);

    }

    @Override
    public void removeStation(Long id) {

    }

    @Override
    public Station getStationById(Long id) {
        return null;
    }

    @Override
    public Station getStationByName(String name) {
        return stationDao.getStationByName(name);
    }

    @Override
    public List<String> getAllStationsNames() {
        List<String> stationNames  = new ArrayList<>();

        for (Station station:
                stationDao.getAllStations()) {
            stationNames.add(station.getStationName());
        }
         return stationNames;
    }

    @Override
    public void addNewStationByForm(StationForm stationForm) {
        Station station = new Station();
        station.setCanton( cantonService.getCantonByName(stationForm.getCantonName()));
        station.setStationName(stationForm.getStationName());

        addNewStation(station);
    }
}
