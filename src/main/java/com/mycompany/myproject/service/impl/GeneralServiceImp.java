package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.persist.entity.Car;
import com.mycompany.myproject.persist.entity.Route;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class GeneralServiceImp implements GeneralService {

    @Autowired
    RouteService routeService;

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

    @Autowired
    CarService carService;

    @Autowired
    ReserveService reserveService;

    @Autowired
    TrainChangeService trainChangeService;

    @Autowired
    RatesService ratesService;

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
        trainDtos = setStatusForTrainDtos(trainDtos, travelDate);
        return trainDtos;
    }

    @Override
    public List<List<TrainDto>> findTrainDtosFromOneToAnotherStationWithDateAndChange(
            Long stationFrom,
            Long stationTo,
            Date travelDate
    ){
        return null;
    }

    @Override
    public List<TrainDto> setStatusForTrainDtos(List<TrainDto> trainDtos, Date date){
        for (TrainDto trainDto :
                trainDtos) {
            trainDto.setTrainTypeDtos(null);
            TrainChange change = trainChangeService.getChangeByTrainIdAndDate(trainDto.getTrainId(), date);
            if (change!=null)
                trainDto.setStatus(change.getStatus());
        };
          return trainDtos;
    }

    @Override
    public List<TrainDto> getTrainsForBoardOnline(String stationName) {
        Long stationId = stationService.getStationByName(stationName).getStationId();
        TrainsDto trainsDto = new TrainsDto();
        Date today =  new Date(Calendar.getInstance().getTime().getTime());
        List<TrainDto> trainDtos = getTrainDtosViaStationAndDate(stationId,today);
        setStatusForTrainDtos(trainDtos, today);
        trainsDto.setTrains(trainDtos);
        return trainDtos;
    }

    @Override
    public List<TrainDto> getTrainsForBoardOnlineById(Long stationId) {
        TrainsDto trainsDto = new TrainsDto();
        Date today =  new Date(Calendar.getInstance().getTime().getTime());
        List<TrainDto> trainDtos = getTrainDtosViaStationAndDate(stationId,today);
        setStatusForTrainDtos(trainDtos, today);
        trainsDto.setTrains(trainDtos);
        return trainDtos;
    }

    @Override
    public List<CarTicketFormDto> findSeatsCars(Long trainId, Long stationFromId, Long stationToId, Date date) {
        List <CarTicketFormDto> carTickets = new ArrayList<>();
        List <Car> cars = trainService.getCarsByTrainId(trainId);
        for (Car car:
             cars) {
            CarTicketFormDto carTicketFormDto = new CarTicketFormDto(car);
            carTicketFormDto.setOccupiedSeats(0L);
            Long carsNumber = trainService.getCarsNumberByTrainIdCarId(trainId, car.getCarId());
            Long totalSeatsNumber = trainService.getTotalNumberOfSeats(trainId, car.getCarId());
            carTicketFormDto.setNumberOfCars(carsNumber);
            carTicketFormDto.setTotalSeatsNumber(totalSeatsNumber);
            carTickets.add(carTicketFormDto);
        }
        float travelLength = 0f;
        List <Route> routes = routeService.getRoutesFromOneStToOtherByTrain(stationFromId, stationToId, trainId);
        for (Route route :
                routes) {
            travelLength+=route.getSection().getLength();
            for (Car car :
                    cars) {
                Long totalOccupiedSeats = reserveService.getOccupancyByRoute(route, car, date);
                Long totalSeatsNumber = trainService.getTotalNumberOfSeats(trainId, car.getCarId());
                Long freeSeats = totalSeatsNumber-totalOccupiedSeats;
                CarTicketFormDto carTicket = carService.findCarTicketByCarId(carTickets, car.getCarId());
                if (totalOccupiedSeats>carTicket.getOccupiedSeats()){
                    carTicket.setOccupiedSeats(totalOccupiedSeats);
                }
            }
        }
        for (CarTicketFormDto carTicket:
             carTickets) {

            float totalRate = ratesService.calculateStandardRate(date,
                    carTicket.getOccupiedSeats(), carTicket.getTotalSeatsNumber() );
            float carRate = carTicket.getCarPriceRate();
            carTicket.setStandardPrice(totalRate*travelLength*carRate);
        }


        return carTickets;
    }


    @Override
    public List<TrainDto> getTrainDtosViaStation(Long stationId){

        List<RouteDto> routeDtos = routeService.getRoutesDtosViaStationId(stationId);
        List <Long> trainIds = this.extractTrainIdsOnRoutes(routeDtos);
        return fillTrainDtoWithData(trainIds, routeDtos, stationId);
    }

    @Override
    public List<TrainDto> fillTrainDtoWithData(List<Long> trainIds, List<RouteDto> routeDtos, Long stationId){
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

    @Override
    public List<TrainDto> getTrainDtosViaStationAndDate(Long stationId, Date travelDate) {
        List<RouteDto> routeDtos = routeService.getRoutesDtosViaStationId(stationId);
        List <Long> trainIds = this.extractTrainIdsOnRoutes(routeDtos);
        List<Long> filteredTrainIds = new ArrayList<>();
        for (Long trainId :
                trainIds) {
            if(trainService.checkTrainDate(trainId, travelDate))
                filteredTrainIds.add(trainId);
        }
        List <TrainDto> trains = fillTrainDtoWithData( filteredTrainIds, routeDtos, stationId);
        trains = setStatusForTrainDtos(trains, travelDate);
        return trains;
    }

}
