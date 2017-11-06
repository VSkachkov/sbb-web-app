package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.service.svc.GeneralService;
import com.mycompany.myproject.service.svc.RouteService;
import com.mycompany.myproject.service.svc.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GeneralServiceImp implements GeneralService {

    @Autowired
    RouteService routeService;

    @Autowired
    TrainService trainService;

    @Override
    public List <Long> extractTrainIdsOnRoutes(List<RouteDto> routeDtos){
        List <Long> trainIds = new ArrayList<>();
        for (RouteDto routeDto :
                routeDtos) {
            if(!trainIds.contains(routeDto.getTrainId())){
                trainIds.add(routeDto.getTrainId());  // extract all train Ids (Long) that go via our station
            }
        }
        return trainIds;
    }

    @Override
    public List<Long> findTrainsViaStation(Long stationId) {
        List<RouteDto> routeDtos = routeService.getRoutesDtosViaStationId(stationId);
        List <Long> trainIds = this.extractTrainIdsOnRoutes(routeDtos);
         return trainIds;
    }

    @Override
    public List <Long> findTrainsBetweenStations(Long stationIdOne, Long stationIdTwo){
        List<Long> trainsViaStationOne = this.findTrainsViaStation(stationIdOne);
        List<Long> trainsViaStationTwo = this.findTrainsViaStation(stationIdTwo);
        trainsViaStationOne.retainAll(trainsViaStationTwo);
        return trainsViaStationOne;
    }

    @Override
    public List<Long> findTrainsFromStationToStation(Long stationFrom, Long stationTo) {
        //the problem is that when we fing trains using method fingTrainsBetween stations
        //this method doed not take into account any time. I.e. it can be later on "From Station"
        //than on "To Station.
        List <Long> trainsBetweenStations = this.findTrainsBetweenStations(stationFrom, stationTo);
        List <Long> trainFromToStation = new ArrayList<>();
        Time departureFromStationFrom = new Time(0, 0, 0);
        Time arrivalToStationTo = new Time(0, 0, 0);;

        for (Long trainId :
                trainsBetweenStations) {
            List <RouteDto> routeDtos = routeService.getRoutesOfTrain(trainId);
            for (RouteDto routeDto :
                    routeDtos) {
                if (routeDto.getStationFromId()==stationFrom)
                    departureFromStationFrom = routeDto.getDeparture();
                if (routeDto.getStationToId()==stationTo)
                    arrivalToStationTo = routeDto.getArrival();
            }
            if (departureFromStationFrom.getTime()<arrivalToStationTo.getTime())
                trainFromToStation.add(trainId);
        }

        return trainFromToStation;
    }

    @Override
    public TrainDto addInitAndLastStationNamesToTrainDto(TrainDto trainDto, Long trainId){
        trainDto.setInitStation(routeService.getInitStationNameOfTrain(trainId));
        trainDto.setLastStation(routeService.getLastStationNameOfTrain(trainId));
        return trainDto;
    }

    @Override
    public TrainDto getTrainInfoFromOneStationToOther(Long stationFrom, Long stationTo, Long trainId){
        TrainDto trainDto = new TrainDto(trainService.getTrainByTrainId(trainId));
        trainDto.setCarriage(trainService.getCarriages(trainId));

        List<Route> routeBetweenStations = routeService.getRoutesFromOneStToOtherByTrain(stationFrom, stationTo, trainId);
        List<RouteDto> routeDtos = routeService.turnRoutesToDtos(routeBetweenStations);

        for (RouteDto routeDto :
                routeDtos) {
                    if (routeDto.getStationFromId() == stationFrom)
                        trainDto.setDepartureTime(routeDto.getDeparture());
                    if (routeDto.getStationToId() == stationTo)
                        trainDto.setArrivalTime(routeDto.getArrival());
        }
        addInitAndLastStationNamesToTrainDto(trainDto, trainId);
        return trainDto;
    }

    @Override
    public List<TrainDto> findTrainDtosFromOneToAnotherStation(Long stationFrom, Long stationTo){
        List <Long> trainIds = this.findTrainsFromStationToStation(stationFrom, stationTo);
        List<TrainDto> trainDtos = new ArrayList<>();

        for (Long trainId :
                trainIds) {
            trainDtos.add(this.getTrainInfoFromOneStationToOther(stationFrom, stationTo, trainId));
        }
        return trainDtos;
    }

    @Override
    public List<TrainDto> findTrainDtosFromOneToAnotherStationWithDate(Long stationFrom, Long stationTo, Date travelDate){
        List <Long> trainIds = this.findTrainsFromStationToStation(stationFrom, stationTo);
        List<Long> trainsFilteredByDate = new ArrayList<>();

        for (Long trainId :
                trainIds) {
            if(trainService.checkTrainDate(trainId, travelDate))
                trainsFilteredByDate.add(trainId);
        }

        List<TrainDto> trainDtos = new ArrayList<>();

        for (Long trainId :
                trainsFilteredByDate) {
            trainDtos.add(this.getTrainInfoFromOneStationToOther(stationFrom, stationTo, trainId));
        }
        return trainDtos;
    }
//
//    @Override
//    private List<Long> findTrainsFromStationToStationWithDate(Long stationFrom, Long stationTo, Date travelDate) {
//        List <Long> allTrainIds = this.findTrainsFromStationToStation(stationFrom, stationTo);
//        routeService.getRoutesOfTrain()
//
//
//        List<TrainDto> trainDtos = new ArrayList<>();
//
//    }


    @Override
    public List<TrainDto> getTrainDtosViaStation(Long stationId){ //TODO! probably this method needs to be refactored

        List<RouteDto> routeDtos = routeService.getRoutesDtosViaStationId(stationId);
        List <Long> trainIds = this.extractTrainIdsOnRoutes(routeDtos);


        List<TrainDto> trainDtos = new ArrayList<>();
        for (Long trainId : //for each train Id we get it's DTO with neccessary information
                trainIds) {
            TrainDto trainDto = trainService.getTrainById(trainId);
            for (RouteDto routeDto :
                    routeDtos) {
                if (routeDto.getTrainId()==trainId) {
                    if (routeDto.getStationFromId() == stationId)
                        trainDto.setDepartureTime(routeDto.getDeparture());
                    if (routeDto.getStationToId() == stationId)
                        trainDto.setArrivalTime(routeDto.getArrival());
                }
            }
            addInitAndLastStationNamesToTrainDto(trainDto, trainId);
            trainDtos.add(trainDto);
        }
        return trainDtos;

    }

}
