package com.mycompany.myproject.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.myproject.persist.entity.Timetable;
import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.TimetableDto;
import com.mycompany.myproject.service.svc.GenericService;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class GenericServiceImpl<T, D, ID extends Serializable> implements GenericService<T, D, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    private DozerBeanMapper mapper;

    protected Class<T> entityClass;

    protected Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    public GenericServiceImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
    }

    public D findOne(ID id) {
        return mapper.map(repository.findOne(id), dtoClass);
    }

    public List<D> findAll() {
        List<D> result = new ArrayList<D>();
        for (T t : repository.findAll()) {
            result.add(mapper.map(t, dtoClass));
        }
        return result;
    }
    
    public void save(D dto) {
        repository.saveAndFlush(mapper.map(dto, entityClass));
    }

//    public static interface AuthorityService extends GenericService<User, UserDto, Long>{
//
//    }

    @Service
    @Transactional
    public static class TimetableServiceImpl //extends GenericServiceImpl<Timetable,TimetableDto, Long>
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
}
