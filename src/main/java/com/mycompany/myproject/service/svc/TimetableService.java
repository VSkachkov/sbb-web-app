package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dto.TimetableDto;

import java.util.List;


public interface TimetableService
{

    List<TimetableDto> getAllTimetable();
    List<Timetable> getAllRoutesThroughStationWithId(Long stationId);
    List<TimetableDto> getAllRoutesThroughStationWithName(String stationName);


}
