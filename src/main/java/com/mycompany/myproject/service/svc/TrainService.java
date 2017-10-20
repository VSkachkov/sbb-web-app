package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.service.dto.TrainDto;
import com.mycompany.myproject.service.dto.TrainsAttribute;
import com.mycompany.myproject.service.svc.GenericService;

import java.sql.Date;
import java.util.List;


public interface TrainService //extends GenericService<Train, TrainDto, Long>
{
    List<TrainDto> getAllTrains();
    void addNewTrain(TrainDto trainDto);
    boolean checkTrainDate(Long trainId, Date travelDate);
    void removeTrain(Long id);
    TrainDto getTrainById(Long id);
    List <TrainsAttribute> filterTrainsByDate(List<TrainsAttribute> trainsInfo, Date date);
}
