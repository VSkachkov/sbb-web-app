package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.service.dao.api.TrainDao;
import com.mycompany.myproject.service.dto.TrainDto;
import com.mycompany.myproject.service.impl.GenericServiceImpl;
import com.mycompany.myproject.service.svc.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional //TODO IMPLEMENT CORRECT VERSION OF SERVICE IMPLEMENTATION
public class TrainServiceImpl //extends GenericServiceImpl<Train,TrainDto, Long>
        implements TrainService {


    @Autowired TrainDao trainDao;
    @Override
    public List<TrainDto> getAllTrains() {
        List<TrainDto> sdto = new ArrayList<>();

        for (Train train :
                trainDao.getAllTrains()) {
            sdto.add(new TrainDto(train));
        }
        return sdto;
    }

    @Override  //TODO IMPLEMENT
    public void addNewTrain(TrainDto trainDto) {
        Train train = new Train();
        train.setTrainName(trainDto.getTrainName());
        train.setDepartMon(trainDto.isDepartMon());
        train.setDepartTue(trainDto.isDepartTue());
        train.setDepartWed(trainDto.isDepartWed());
        train.setDepartThu(trainDto.isDepartThu());
        train.setDepartFri(trainDto.isDepartFri());
        train.setDepartSat(trainDto.isDepartSat());
        train.setDepartSun(trainDto.isDepartSun());
        train.setCapacity(trainDto.getCapacity());
        trainDao.addNewTrain(train);

    }

    @Override //TODO IMPLEMENT
    public void removeTrain(Long id) {

    }

    @Override //TODO IMPLEMENT
    public TrainDto getTrainById(Long id) {
        return null;
    }
}
