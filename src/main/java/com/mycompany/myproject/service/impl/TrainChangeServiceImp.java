package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.TrainChangeDao;
import com.mycompany.myproject.dto.TrainChangeDto;
import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.TrainChangeService;
import com.mycompany.myproject.service.svc.TrainService;
import com.mycompany.myproject.util.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class TrainChangeServiceImp implements TrainChangeService {

    @Autowired
    TrainChangeDao trainChangeDao;

    @Autowired
    TrainService trainService;

    @Override
    public TrainChange getChangeById(Long id) {
        return trainChangeDao.getChangeById(id);
    }

    @Override
    public TrainChange getChangeByTrainDate(Train train, Date date) {
        return trainChangeDao.getChangeByTrainDate(train, date);
    }

    @Override
    public Date getDateChangeById(Long changeId) {
        return trainChangeDao.getDateByChangeId(changeId);
    }

    @Override
    public String getStatusChangeById(Long changeId) {
        return trainChangeDao.getStatusByChangeId(changeId);
    }

    @Override
    public void informMQService() {
        Sender sender = new Sender();
        sender.send();
    }

    @Override
    public TrainChange getChangeByTrainIdAndDate(Long trainId, Date date) {
        Train train = trainService.getTrainByTrainId(trainId);
        return getChangeByTrainDate(train, date);
    }

    @Override
    public void addTrainChange(TrainChange trainChange) {
        trainChangeDao.addTrainChange(trainChange);
    }

    @Override
    public void updateStatusByChangeId(Long changeId, String newStatus) {
        trainChangeDao.updateStatusByChangeId(changeId, newStatus);
    }

    @Override
    public List<TrainChangeDto> getChanges() {
        List<TrainChange> trainChanges = trainChangeDao.getAllChanges();
        List<TrainChangeDto> trainChangeDtos = new ArrayList<>();
        for (TrainChange trainchange :
                trainChanges) {
            trainChangeDtos.add(new TrainChangeDto(trainchange));
        }
        return trainChangeDtos;
    }

    @Override
    public boolean saveChangeToDb(TrainChangeDto changeDto) {
        Long changeId = changeDto.getChangeId();
        String status = changeDto.getStatus();
        Date travelDate = changeDto.getTravelDate();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Long dateWithoutTime = cal.getTime().getTime();
        Long travelDateLong = changeDto.getTravelDateLong();
        Long trainId = changeDto.getTrainId();
        TrainChange trainChange = getChangeById(changeId);
        if (trainChange != null) {
            updateStatusByChangeId(changeId, status);
            if (trainChange.getTravelDate().getTime() == dateWithoutTime)
                informMQService();
        } else {
            if (!trainService.checkTrainDate(trainId, travelDate))
                return false;
            if (travelDate == null || trainId == null || status == null || status.equals(""))
                return false;
            trainChange = new TrainChange();
            trainChange.setTrain(trainService.getTrainByTrainId(trainId));
            trainChange.setTravelDate(travelDate);
            trainChange.setStatus(status);
            addTrainChange(trainChange);
            informMQService();
            return true;
        }
        return true;
    }

    @Override
    public boolean deleteChangeFromDB(TrainChangeDto changeDto) {
        if (getChangeById(changeDto.getChangeId()) == null)
            return false;
        trainChangeDao.deleteChange(changeDto.getChangeId());
        return true;
    }
}
