package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.dto.TrainDto;

import java.sql.Date;
import java.util.List;

public interface GeneralService {

    List<TrainDto> getTrainDtosViaStation(Long stationId);
    List <Long> extractTrainIdsOnRoutes(List<RouteDto> routeDtos);
    List <Long> findTrainsViaStation(Long stationId);
    TrainDto getTrainInfoFromOneStationToOther(Long stationFrom, Long stationTo, Long trainId);
    TrainDto addInitAndLastStationNamesToTrainDto(TrainDto trainDto, Long trainId);
    List<TrainDto> findTrainDtosFromOneToAnotherStationWithDate(Long stationFrom, Long stationTo, Date travelDate);
    List<TrainDto> findTrainDtosFromOneToAnotherStation(Long stationFrom, Long stationTo);
    List <Long> findTrainsBetweenStations(Long stationIdOne, Long stationIdTwo);
    List <Long> findTrainsFromStationToStation(Long stationFrom, Long stationTo);
}
