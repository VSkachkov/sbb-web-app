package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.*;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.service.svc.TrainService;
import com.mycompany.myproject.support.MyTimeConverter;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @RequestMapping(value = "/TrainsLink", method = RequestMethod.GET)
    public String setConditionsforTrainsBetweenStations(Model model) {
//        model.addAttribute("greeting", new Greeting());
//        StationDto stdo = new StationDto();

        model.addAttribute("trainsForm", new TrainsForm());
        logger.error("We are in GET method!");
        return "Trains";
    }

//    @RequestMapping(value = "/resultTrainsLink", method = RequestMethod.POST)
//    public ModelAndView getStationFiltered(@ModelAttribute TrainsForm trainsForm) {
//        ModelAndView modelAndView = new ModelAndView();
////        logger.error("Time = "+trainsForm.getTravelTimeFrom().toString());
////        logger.error("Time = "+trainsForm.getTravelTimeTo().toString());
//        logger.error("Date = "+trainsForm.getTravelDate());
//        logger.error("From = "+trainsForm.getStationFrom());
//        logger.error("To = "+trainsForm.getStationTo());
////        modelAndView.addObject("trainsform", trainsForm);
//        List<Long> trainsList = new ArrayList<>();
//        trainsList.add(1L);
//        trainsList.add(4L);
//        trainsList.add(6L);
//
//        PassengerForm passengerForm = new PassengerForm();
//        modelAndView.addObject("trainsForm",trainsForm );
//        modelAndView.addObject("trainsList", trainsList);
//        modelAndView.addObject("showTravelDate", trainsForm.getTravelDate().toString());
//        modelAndView.addObject("passengerForm", passengerForm);
//        passengerForm.setFromStation(trainsForm.getStationFrom());
//        passengerForm.setToStation(trainsForm.getStationTo()); //TODO finish code here\
//
////        modelAndView.addObject("timetableModel", timetableService.getAllRoutesThroughStationWithName(trainsForm.getStationTo()));
////        ////PREVIOUS VERSION
//        List<TrainsAttribute> trainsByRouteAndTime = timetableService.
//                getTimetableBetweenStations(trainsForm.getStationFrom(), trainsForm.getStationTo(),
//                trainsForm.getEarlyTime(), trainsForm.getLateTime());
//
//        // Future version WHERE TIME INSTEAD OF STRING
////        List<TrainsAttribute> trainsByRouteAndTime = timetableService.
////                getTimetableBetweenStations(trainsForm.getStationFrom(), trainsForm.getStationTo(),
////                        trainsForm.getTravelTimeFrom(), trainsForm.getTravelTimeTo());
//
//        //sort list by date:
//        List<TrainsAttribute> filteredTrainsList = trainService.filterTrainsByDate(trainsByRouteAndTime, trainsForm.getTravelDate());
//
//
//
//        modelAndView.addObject("timetableModel",
//                filteredTrainsList);
//        modelAndView.setViewName("TrainsResult");
//        return modelAndView;
//    }

    @RequestMapping(value = "/resultTrainsLink", method = RequestMethod.POST)
    public String getStationFiltered(Model model, @ModelAttribute("trainsForm") TrainsForm trainsForm) {
//        logger.error("Time = "+trainsForm.getTravelTimeFrom().toString());
//        logger.error("Time = "+trainsForm.getTravelTimeTo().toString());
//        logger.error("Date = "+trainsForm.getTravelDate());
//        logger.error("From = "+trainsForm.getStationFrom());
//        logger.error("To = "+trainsForm.getStationTo());
//        modelAndView.addObject("trainsform", trainsForm);
        List<Long> trainsList = new ArrayList<>();
        trainsList.add(1L);
        trainsList.add(4L);
        trainsList.add(6L);
         PassengerForm passengerForm = new PassengerForm();
        model.addAttribute("trainsForm",trainsForm );
        model.addAttribute("TravelDate", trainsForm.getTravelDate());
        model.addAttribute("StationFrom", trainsForm.getStationFrom());
        model.addAttribute("StationTo", trainsForm.getStationTo());
//        model.addAttribute("trainsList", trainsList);
//        model.addAttribute("showTravelDate", trainsForm.getTravelDate().toString());

        passengerForm.setFromStation(trainsForm.getStationFrom());
        passengerForm.setToStation(trainsForm.getStationTo()); //TODO finish code here\
        passengerForm.setTravelDate(trainsForm.getTravelDate());
        model.addAttribute("passengerForm", passengerForm);
        List<TrainsAttribute> trainsByRouteAndTime = timetableService.
                getTimetableBetweenStations(trainsForm.getStationFrom(), trainsForm.getStationTo(),
                        trainsForm.getEarlyTime(), trainsForm.getLateTime());

        List<TrainsAttribute> filteredTrainsList = trainService.filterTrainsByDate(trainsByRouteAndTime,
                trainsForm.getTravelDate());

        model.addAttribute("timetableModel",
                filteredTrainsList);
        return "TrainsResult";
    }




}    

 
