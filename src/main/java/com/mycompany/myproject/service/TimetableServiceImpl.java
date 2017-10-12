package com.mycompany.myproject.service;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dto.TimetableDto;
import org.springframework.stereotype.Service;
import com.mycompany.myproject.service.StationService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TimetableServiceImpl extends GenericServiceImpl<Timetable,TimetableDto, Long>
                                    implements TimetableService{

    @Autowired
    StationService stationservice;

    @Override
    public void findByStationName(String stationName) {
//        stationservice.
    }


}
