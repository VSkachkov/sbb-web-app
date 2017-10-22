package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.service.svc.TrainService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
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
    private MessageSource ms;
    

    @RequestMapping(value = "/trainsList", method = RequestMethod.GET)
    public @ResponseBody List<TrainDto> usersList() {
        logger.debug("get json trains list");
        return trainService.getAllTrains();
    }

    @RequestMapping(value = "/trains", method = RequestMethod.GET)
    public String setConditionsforTrainsBetweenStations(Model model) {
//        model.addAttribute("greeting", new Greeting());
//        StationDto stdo = new StationDto();

        model.addAttribute("trainsForm", new TrainsForm());
        logger.info("We are in GET method!");
        return "trains";
    }


    @RequestMapping(value = "/resultTrains", method = RequestMethod.POST)
    public String getStationFiltered(Model model, @ModelAttribute("trainsForm") TrainsForm trainsForm) {
        List<Long> trainsList = new ArrayList<>();
//
//         PassengerForm passengerForm = new PassengerForm();
//        model.addAttribute("trainsForm",trainsForm );
//        model.addAttribute("TravelDate", trainsForm.getTravelDate());
//        model.addAttribute("StationFrom", trainsForm.getStationFrom());
//        model.addAttribute("StationTo", trainsForm.getStationTo());
////        model.addAttribute("trainsList", trainsList);
////        model.addAttribute("showTravelDate", trainsForm.getTravelDate().toString());
//
//        passengerForm.setFromStation(trainsForm.getStationFrom());
//        passengerForm.setToStation(trainsForm.getStationTo()); //TODO finish code here\
//        passengerForm.setTravelDate(trainsForm.getTravelDate());
//        model.addAttribute("passengerForm", passengerForm);
        List<TrainsAttribute> trainsByRouteAndTime = timetableService.
                getTimetableBetweenStations(trainsForm.getStationFrom(), trainsForm.getStationTo(),
                        trainsForm.getEarlyTime(), trainsForm.getLateTime());

        List<TrainsAttribute> filteredTrainsList = trainService.filterTrainsByDate(trainsByRouteAndTime,
                trainsForm.getTravelDate());

        model.addAttribute("timetableModel",
                filteredTrainsList);
        return "trainsResult";
    }




}    

 
