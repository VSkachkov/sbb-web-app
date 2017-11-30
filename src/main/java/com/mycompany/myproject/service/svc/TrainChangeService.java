package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.TrainChangeDto;
import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.persist.entity.TrainChange;

import java.sql.Date;
import java.util.List;

public interface TrainChangeService {
    /**
     * gets train change info by it's id
     *
     * @param id change id
     * @return entity
     */
    TrainChange getChangeById(Long id);

    /**
     * finds change by train and travel date
     * @param train train ID
     * @param date travel date
     * @return train change entity
     */
    TrainChange getChangeByTrainDate(Train train, Date date);

    /**
     *
     * @param changeId
     * @return
     */
    Date getDateChangeById(Long changeId);

    /**
     * finds status change message by change ID
     * @param changeId
     * @return change message
     */
    String getStatusChangeById(Long changeId);

    /**
     * informs MQ service about new or updated messages
     */
    void informMQService();

    /**
     * gets change by params
     * @param trainId
     * @param date
     * @return train Change
     */
    TrainChange getChangeByTrainIdAndDate(Long trainId, Date date);

    /**
     * adds new train change to DB
     * @param trainChange
     */
    void addTrainChange(TrainChange trainChange);

    /**
     * update message status for existing change in DB
     * @param changeId
     * @param newStatus
     */
    void updateStatusByChangeId(Long changeId, String newStatus);

    /**
     * gets DTO af all changes in DB
     * @return train changes
     */
    List<TrainChangeDto> getChanges();

    /**
     * saves change to DB
     * @param changeDto change DTO to sace
     * @return true if success
     */
    boolean saveChangeToDb(TrainChangeDto changeDto);

    /**
     * deletes change ID from DB
     * @param changeDto
     * @return true if OK
     */
    boolean deleteChangeFromDB(TrainChangeDto changeDto);
}
