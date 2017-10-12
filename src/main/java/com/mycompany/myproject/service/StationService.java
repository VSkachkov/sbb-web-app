package com.mycompany.myproject.service;


import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.persist.repo.StationRepo;
import com.mycompany.myproject.service.dto.StationDto;


public interface StationService extends GenericService<Station, StationDto, Long>{


//    public Station findByStationName(String stationName);

}
