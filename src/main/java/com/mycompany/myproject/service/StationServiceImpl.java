package com.mycompany.myproject.service;


import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.persist.repo.StationRepo;
import com.mycompany.myproject.service.dto.StationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StationServiceImpl extends GenericServiceImpl<Station,StationDto, Long> implements StationService{

// private StationRepo stationRepo;
//
//    @Autowired
//    public Station findByStationName(String stationName) {
//        this.stationRepo = stationRepo;
//        for (Station station: stationRepo.findAll()
//             ) {
//            if (station.getName().equals(stationName))
//                return station;
//        }
//        return null;
//    }
}
