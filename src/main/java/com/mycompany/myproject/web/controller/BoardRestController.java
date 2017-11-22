package com.mycompany.myproject.web.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.model.Response;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.GeneralService;
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


@RequestMapping(  value = "/board/{stationName}", produces = APPLICATION_JSON_VALUE,
                                                  method = RequestMethod.GET)
    public List<TrainDto> boardInfo(@PathVariable("stationName") String stationName) {
    return generalService.getTrainsForBoardOnline(stationName);
    }


    @RequestMapping(  value = "/status/{status}", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public void  statusInfo(@PathVariable("status") String status) {
        Date today =  new Date(Calendar.getInstance().getTime().getTime());
        TrainChange change = trainChangeService.getChangeByTrainIdAndDate(1L, today);
        trainChangeService.updateStatusByChangeId(change.getChangeId(), status);
        Sender sender = new Sender();
        sender.send();
    }

    @RequestMapping(  value = "/stations", produces = APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public List<StationDto>  stationsForBoardOnline() {
        return stationService.getAllStationDtos();
    }


//    @CrossOrigin
//    @RequestMapping(  value = "/addStationRest", consumes = APPLICATION_JSON_VALUE,
//            method = RequestMethod.POST)
//    public JSONPObject stationsAdd(JSONPObject inputJSonObj) {
//    String input = (String) inputJSonObj.getValue();
//        return null;
//    }



}
