package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.PersonDto;
import com.mycompany.myproject.dto.PersonsDto;
import com.mycompany.myproject.dto.TrainDto;
import com.mycompany.myproject.dto.TrainsDto;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.GeneralService;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TrainChangeService;
import com.mycompany.myproject.util.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

//    @RequestMapping( value = "/board", method = RequestMethod.GET)
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


}
