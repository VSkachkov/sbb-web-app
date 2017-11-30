package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.CarTicketFormDto;
import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.dto.TrainDto;

import java.sql.Date;
import java.util.List;

public interface GeneralService {

    /**
     * gets train DTO via station
     *
     * @param stationId station ID
     * @return list of train DTOs
     */
    List<TrainDto> getTrainDtosViaStation(Long stationId);

    /**
     * gets train DTOs taking into account station and travel date
     * @param stationId station ID
     * @param travelDate travel date
     * @return train DTOs
     */
    List<TrainDto> getTrainDtosViaStationAndDate(Long stationId, Date travelDate);

    /**
     * extracts train ids which on database routes
     * @param routeDtos route DTOs
     * @return list of trains IDs
     */
    List<Long> extractTrainIdsOnRoutes(List<RouteDto> routeDtos);

    /**
     *find trains via station based on it's ID
     * @param stationId station ID
     * @return list of trains IDs
     */
    List<Long> findTrainsViaStation(Long stationId);

    /**
     * sets status for board online
     * @param trainDtos train DTOs
     * @param date travel date
     * @return train DTOs with updated status
     */
    List<TrainDto> setStatusForTrainDtos(List<TrainDto> trainDtos, Date date);

    /**
     * fills TRAIN DTO with information about trains
     * @param stationFrom station ID from
     * @param stationTo station ID to
     * @param trainId train ID
     * @return train DTOs with info
     */
    TrainDto getTrainInfoFromOneStationToOther(Long stationFrom, Long stationTo, Long trainId);

    /**
     * adds to train DTO names of initial and last station
     * @param trainDto train DTO to inject data
     * @param trainId train ID
     * @return update Train DTO
     */
    TrainDto addInitAndLastStationNamesToTrainDto(TrainDto trainDto, Long trainId);

    /**
     * finds trains from none station to another taking into account date
     * @param stationFrom station FROM id
     * @param stationTo station TO id
     * @param travelDate travel date
     * @return list of trains in DTOs
     */
    List<TrainDto> findTrainDtosFromOneToAnotherStationWithDate(Long stationFrom, Long stationTo, Date travelDate);

    /**
     * finds trains from one station to another without considering date
     * @param stationFrom ID FROM
     * @param stationTo ID TO
     * @return train DTOs
     */
    List<TrainDto> findTrainDtosFromOneToAnotherStation(Long stationFrom, Long stationTo);

    /**
     * finds trains from one station to another
     * @param stationIdOne id One
     * @param stationIdTwo id two
     * @return list of train IDs
     */
    List<Long> findTrainsBetweenStations(Long stationIdOne, Long stationIdTwo);

    /**
     * finds trains between stations with direction
     * @param stationFrom from station
     * @param stationTo to station
     * @return train IDs
     */
    List<Long> findTrainsFromStationToStation(Long stationFrom, Long stationTo);

    /**
     * fills train DTOs with data
     * @param trainIds train IDs
     * @param routeDtos routes of these trains
     * @param stationId stations IDs
     * @return trains DTOs with new data
     */
    List<TrainDto> fillTrainDtoWithData(List<Long> trainIds, List<RouteDto> routeDtos, Long stationId);

    /**
     * finds train dto by params
     * @param stationFrom station FROM id
     * @param stationTo station TO id
     * @param travelDate date
     * @return train DTOs
     */
    List<List<TrainDto>> findTrainDtosFromOneToAnotherStationWithDateAndChange(Long stationFrom,
                                                                               Long stationTo,
                                                                               Date travelDate);

    /**
     * provides information for SBB board online service
     * @param stationName station name
     * @return trains DTOs
     */
    List<TrainDto> getTrainsForBoardOnline(String stationName);

    /**
     * provides DTO for SBB board online by station ID
     * @param stationId station ID
     * @return list of train DTOs via station
     */
    List<TrainDto> getTrainsForBoardOnlineById(Long stationId);

    /**
     * finds number of free seats by parameters
     * @param trainId train ID
     * @param stationFromId station FROM id
     * @param stationToId station TO id
     * @param date date
     * @return car tickets
     */
    List<CarTicketFormDto> findSeatsCars(Long trainId, Long stationFromId, Long stationToId, Date date);
}
