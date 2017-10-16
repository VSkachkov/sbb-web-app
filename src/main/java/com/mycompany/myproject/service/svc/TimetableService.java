package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Authority;
import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dto.AuthorityDto;
import com.mycompany.myproject.service.dto.TimetableDto;

import java.util.List;


public interface TimetableService// extends GenericService<Timetable, TimetableDto, Long>
{

    List<TimetableDto> getAllTimetable();
    List<Timetable> getAllRoutesThroughStationWithId(Long stationId);
    List<TimetableDto> getAllRoutesThroughStationWithName(String stationName);

    interface AuthorityService extends GenericService<Authority, AuthorityDto, Long> {

    }
}
