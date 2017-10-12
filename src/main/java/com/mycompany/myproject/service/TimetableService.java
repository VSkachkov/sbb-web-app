package com.mycompany.myproject.service;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dto.TimetableDto;


public interface TimetableService extends GenericService<Timetable, TimetableDto, Long>{


    void findByStationName(String zurich);
}
