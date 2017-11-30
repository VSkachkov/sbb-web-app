package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.CarTicketFormDto;
import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.dto.TrainDto;

import java.sql.Date;
import java.util.List;

public interface GeneralService {

    List<TrainDto> getTrainDtosViaStation(Long stationId);

    List<TrainDto> getTrainDtosViaStationAndDate(Long stationId, Date travelDate);

    List<Long> extractTrainIdsOnRoutes(List<RouteDto> routeDtos);

    List<Long> findTrainsViaStation(Long stationId);

    List<TrainDto> setStatusForTrainDtos(List<TrainDto> trainDtos, Date date);

    TrainDto getTrainInfoFromOneStationToOther(Long stationFrom, Long stationTo, Long trainId);

    TrainDto addInitAndLastStationNamesToTrainDto(TrainDto trainDto, Long trainId);

    List<TrainDto> findTrainDtosFromOneToAnotherStationWithDate(Long stationFrom, Long stationTo, Date travelDate);

    List<TrainDto> findTrainDtosFromOneToAnotherStation(Long stationFrom, Long stationTo);

    List<Long> findTrainsBetweenStations(Long stationIdOne, Long stationIdTwo);

    List<Long> findTrainsFromStationToStation(Long stationFrom, Long stationTo);

    List<TrainDto> fillTrainDtoWithData(List<Long> trainIds, List<RouteDto> routeDtos, Long stationId);

    List<List<TrainDto>> findTrainDtosFromOneToAnotherStationWithDateAndChange(Long stationFrom,
                                                                               Long stationTo,
                                                                               Date travelDate);

    List<TrainDto> getTrainsForBoardOnline(String stationName);

    List<TrainDto> getTrainsForBoardOnlineById(Long stationId);

    List<CarTicketFormDto> findSeatsCars(Long trainId, Long stationFromId, Long stationToId, Date date);
}
