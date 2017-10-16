package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.TimetableDto;
import com.mycompany.myproject.service.svc.TimetableService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TimetableServiceImpl// extends GenericServiceImpl<Timetable,TimetableDto, Long>
                                    implements TimetableService {


    @Autowired
    TimetableDao timetableDao;
    @Override
    public List<TimetableDto> getAllTimetable() {
        List<TimetableDto> sdto = new ArrayList<>();

        for (Timetable timetable :
                timetableDao.getAllTimetable()) {
            sdto.add(new TimetableDto(timetable));
        }
        return sdto;
    }

    @Override
    public List<Timetable> getAllRoutesThroughStationWithId(Long stationId) {
        return null;
    }

    @Override
    public List<TimetableDto> getAllRoutesThroughStationWithName(String stationName) {
        return null;
    }
}
