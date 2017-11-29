package com.mycompany.myproject.web.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.model.Response;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.GeneralService;
import com.mycompany.myproject.service.svc.RatesService;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TrainChangeService;
import com.mycompany.myproject.util.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
//@Controller

public class BoardRestController {

    @Autowired
    GeneralService generalService;

    @Autowired
    StationService stationService;

    @Autowired
    TrainChangeService trainChangeService;

    @Autowired
    RatesService ratesService;


    @RequestMapping(value = "/board/{stationName}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<TrainDto> boardInfo(@PathVariable("stationName") String stationName) {
        return generalService.getTrainsForBoardOnline(stationName);
    }


    @RequestMapping(value = "/boardById/{stationId}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<TrainDto> boardInfoByStationId(@PathVariable("stationId") Long stationId) {
        return generalService.getTrainsForBoardOnlineById(stationId);
    }

    @RequestMapping(value = "/boardByStationIdDate/{stationId}/{date}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<TrainDto> boardInfoByStationIdAndDate(@PathVariable("stationId") Long stationId,
                                                      @PathVariable("date") Long dateLong) {
        Date date = new Date(dateLong);
        return generalService.getTrainDtosViaStationAndDate(stationId, date);
    }

    @RequestMapping(value = "/status/{status}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public void statusInfo(@PathVariable("status") String status) {
        Date today = new Date(Calendar.getInstance().getTime().getTime());
        TrainChange change = trainChangeService.getChangeByTrainIdAndDate(1L, today);
        trainChangeService.updateStatusByChangeId(change.getChangeId(), status);
        Sender sender = new Sender();
        sender.send();
    }

    @RequestMapping(value = "/stations", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<StationDto> stationsForBoardOnline() {
        return stationService.getAllStationDtos();
    }


    @RequestMapping(value = "/trainsByStationIdsDate/{stationFromId}/{stationToId}/{date}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<TrainDto> findTrainsBetweenStationsWithDate(@PathVariable("stationFromId") Long stationFromId,
                                                            @PathVariable("stationToId") Long stationToId,
                                                            @PathVariable("date") Long dateLong) {
        if (stationFromId==null||stationToId==null||dateLong==null||stationFromId==stationToId)
            return null;
        Date date = new Date(dateLong);
        return generalService.findTrainDtosFromOneToAnotherStationWithDate(stationFromId, stationToId, date);
    }

    @RequestMapping(value = "/carsByTrainStationsDate/{trainId}/{stationFromId}/{stationToId}/{date}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<CarTicketFormDto> findSeatsInTrainBetweenStationsWithDate(
                                                            @PathVariable("trainId") Long trainId,
                                                            @PathVariable("stationFromId") Long stationFromId,
                                                            @PathVariable("stationToId") Long stationToId,
                                                            @PathVariable("date") Long dateLong) {
        if (stationFromId==null||stationToId==null||dateLong==null||stationFromId==stationToId)
            return null;
        if(trainId==null)
            return null;
        Date date = new Date(dateLong);
        return generalService.findSeatsCars(trainId, stationFromId, stationToId, date);
    }

    @RequestMapping(value = "/correctionAgeRate/{date}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public float provideAgeCorrection(@PathVariable("date") Long dateLong){
        float highestRate = ratesService.getHighestAgeRate();
        float correctRate = ratesService.getRateAgeByBirthday(new Date(dateLong));
        return correctRate/highestRate;
    }



}
