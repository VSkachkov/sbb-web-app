package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.service.dao.api.StationDao;
import com.mycompany.myproject.service.svc.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StationServiceImpl //extends GenericServiceImpl<Station,StationDto, Long>
        implements StationService {

    @Autowired
    private StationDao stationDao;

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
}
