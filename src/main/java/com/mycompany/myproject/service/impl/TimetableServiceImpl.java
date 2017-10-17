package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.TimetableDto;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


//
//@Service
//@Transactional
//public class TimetableServiceImpl implements TimetableService {
//
//
//    @Autowired
//    TimetableDao timetableDao;
//    @Override
//    public List<TimetableDto> getAllTimetable() {
//        List<TimetableDto> sdto = new ArrayList<>();
//
//        for (Timetable timetable :
//                timetableDao.getAllTimetable()) {
//            sdto.add(new TimetableDto(timetable));
//        }
//        return sdto;
//    }
//
//    @Override
//    public List<Timetable> getAllRoutesThroughStationWithId(Long stationId) {
//        return null;
//    }
//
//    @Override
//    public List<TimetableDto> getAllRoutesThroughStationWithName(String stationName) {
//        return null;
//    }
//}
//


@Service
@Transactional
public class TimetableServiceImpl //extends GenericServiceImpl<Timetable,TimetableDto, Long>
        implements TimetableService {

    @Autowired
    StationService stationservice;
    @Autowired
    private TimetableDao timetableDao;

    //    @Override
    //    public List<TimetableDto> getAllTimetable() {
    //        List <TimetableDto> ltdto = new ArrayList<TimetableDto>();
    //        timetableDao.getAllTimetable()
    //                .stream().forEachOrdered(ae -> ltdto.add(new TimetableDto(ae)));
    //        return ltdto;
    //    }

    @Override
    public List<TimetableDto> getAllTimetable() {
        List<TimetableDto> tdto = new ArrayList<>();
        for (Timetable timetable:
                timetableDao.getAllTimetable()) {
            tdto.add(new TimetableDto(timetable));
        }
        return tdto;

    }


    @Override
    public List<Timetable> getAllRoutesThroughStationWithId(Long stationId) {
        return timetableDao.getAllRoutesThroughStationId(stationId);
    }

    @Override
    public List<TimetableDto> getAllRoutesThroughStationWithName(String stationName) {
        List<TimetableDto> tdto = new ArrayList<>();
        for (Timetable timetable:
                timetableDao.getAllRoutesThroughStationName(stationName)) {
            tdto.add(new TimetableDto(timetable));
        }
        return tdto;
    }


}
