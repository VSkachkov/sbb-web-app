package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.persist.entity.TrainTypeNumber;
import com.mycompany.myproject.service.svc.*;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("request")
public class TrainController {

    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private DozerBeanMapper mapper;
//
    @Autowired
    private TrainService trainService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    CarService carService;

    @Autowired
    TrainTypeService trainTypeService;

    @Autowired
    TrainTypeNumberService trainTypeNumberService;

    @Autowired
    private MessageSource ms;


    @CrossOrigin
    @RequestMapping(value = "/trainsList", method = RequestMethod.GET)
    public @ResponseBody List<TrainDto> usersList() {
        logger.info("Request trains list");
        return trainService.getAllTrains();
    }

    @RequestMapping(value = "/trains", method = RequestMethod.GET)
    public String setConditionsforTrainsBetweenStations(Model model) {

        List<String> stationsList = new ArrayList<>();
        stationsList = timetableService.getAllStationsNames();
        model.addAttribute("someList", stationsList);
        model.addAttribute("trainsForm", new TrainsForm());
        logger.info("Setting conditions for trains between stations");
        return "trains";
    }


    @RequestMapping(value = "/resultTrains", method = RequestMethod.POST)
    public String getStationFiltered(Model model, @ModelAttribute("trainsForm") TrainsForm trainsForm) {
        logger.info("Providing information about traons between stations");
        List<Long> trainsList = new ArrayList<>();
        List<TrainsAttribute> trainsByRouteAndTime = timetableService.
                getTimetableBetweenStations(trainsForm.getStationFrom(), trainsForm.getStationTo(),
                        trainsForm.getEarlyTime(), trainsForm.getLateTime());

        List<TrainsAttribute> filteredTrainsList = trainService.filterTrainsByDate(trainsByRouteAndTime,
                trainsForm.getTravelDate());

        model.addAttribute("timetableModel",
                filteredTrainsList);
        logger.info("Providing information about trains between stations. Before sending to JSP");
        return "trainsResult";
    }


    @CrossOrigin
    @RequestMapping(value = "/getTrainTypes", method = RequestMethod.GET)
    public @ResponseBody
    List<TrainTypeDto> getTrainTypes() {
        logger.info("Web-server requests train types info");
        return trainTypeService.getAllTrainTypes();
    }

    @CrossOrigin
    @RequestMapping(value = "/getTrainTypeNumbers", method = RequestMethod.GET)
    public @ResponseBody
    List<TrainTypeNumber> getTrainTypesNumbers() {
        logger.info("Web-server requests carriages info");
        return trainTypeNumberService.getAllTrainTypesNumbers();
    }

    @CrossOrigin
    @RequestMapping(value = "/saveType", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> saveType(@RequestBody TrainTypeDto trainTypeDto) {
        logger.info("Web-server updates/adds train types to DB: " + trainTypeDto.toString());
        boolean result = trainTypeService.addNewTrainType(trainTypeDto);
        if(result)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value="saveTrain", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> saveTrain(@RequestBody TrainDto trainDto) {
        logger.info("Web-server adds train to DB: " + trainDto.toString());
        TrainDto newTrain = trainDto;
        boolean result = trainService.addNewTrainFromWeb(trainDto);
        logger.info("server result: " + result);
        if(result)
            return new ResponseEntity(HttpStatus.OK);
        else
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value="deleteTrain", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> deleteTrain(@RequestBody TrainDto trainDto) {
        logger.info("Web-server deletes train to DB: " + trainDto.toString());
        boolean result = trainService.deleteTrainFromWeb(trainDto);
        logger.info("server result: " + result);
        if(result)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}    

 
