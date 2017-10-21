package com.mycompany.myproject.service.svc;


import com.mycompany.myproject.persist.entity.Station;
//import com.mycompany.myproject.persist.repo.StationRepo;
import com.mycompany.myproject.service.dto.StationDto;
import com.mycompany.myproject.service.dto.StationForm;

import java.util.List;


public interface StationService// extends GenericService<Station, StationDto, Long>
{

    List<Station> getAllStations();
    void addNewStation(Station station);
    void removeStation(Long id);
    Station getStationById(Long id);
    Station getStationByName(String name);
    List<String>getAllStationsNames();
    void addNewStationByForm(StationForm stationForm);
}
