package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.dao.api.StationDao;
import com.mycompany.myproject.dto.StationForm;
import com.mycompany.myproject.service.svc.CantonService;
import com.mycompany.myproject.service.svc.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements StationService {

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
        return stationDao.getStationById(id);
    }

    @Override
    public Station getStationByName(String name) {
        return stationDao.getStationByName(name);
    }

    @Override
    public List<String> getAllStationsNames() {
        List<String> stationNames = new ArrayList<>();

        for (Station station :
                stationDao.getAllStations()) {
            stationNames.add(station.getStationName());
        }
        return stationNames;
    }

    @Override
    public void addNewStationByForm(StationForm stationForm) {
        Station station = new Station();
        station.setCanton(cantonService.getCantonByName(stationForm.getCantonName()));
        station.setStationName(stationForm.getStationName());
        station.setLatitude(stationForm.getLatitude());
        station.setLongitude(stationForm.getLongitude());
        addNewStation(station);
    }

    @Override
    public boolean addNewStationByDto(StationDto stationDto) {
        Station station = new Station();


        station.setCanton(cantonService.getCantonById(stationDto.getCantonId()));
        station.setStationName(stationDto.getStationName());
        addNewStation(station);
        return true;
    }

    @Override
    public boolean isStationIdInDb(Long stationId) {
        if (getStationById(stationId) != null)
            return true;
        else return false;
    }

    @Override
    public boolean isStationNameInDb(String stationName) {
        if (getStationByName(stationName) != null)
            return true;
        else return false;
    }

    @Override
    public List<StationDto> getAllStationDtos() {
        List<Station> stations = this.getAllStations();
        List<StationDto> stationDtos = new ArrayList<>();

        for (Station station :
                stations) {
            StationDto stationDto = new StationDto(station);
            stationDtos.add(stationDto);
        }

        return stationDtos;
    }

    @Override
    public void updateStation(StationDto stationDto) {
        stationDao.updateStation(stationDto);
    }

    @Override
    public boolean deleteStationFromDB(StationDto stationDto) {
        if (stationDto.getStationId() == null)
            return false;
        if (getStationById(stationDto.getStationId()) == null)
            return false;
        stationDao.removeStation(stationDto.getStationId());
        return true;
    }
}
