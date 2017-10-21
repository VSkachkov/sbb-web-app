package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.dto.TimetableDto;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("request")
public class TimetableController {

    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private DozerBeanMapper mapper;


    @Autowired
    private TimetableService timetableService;

    @Autowired
    StationService stationService;


    @Autowired
    private MessageSource ms;


    @RequestMapping(value = "/Timetable", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        StationDto stdo = new StationDto();


        List<String> stationsList = new ArrayList<>();
        stationsList = stationService.getAllStationsNames();
//        model.addAttribute("myform", new MyForm());
        model.addAttribute("someList", stationsList);

        model.addAttribute("station", stdo);
        model.addAttribute("timetableModel", timetableService.getAllTimetable());
        logger.error("We are in GET method!");
        return "Timetable";
    }


    @RequestMapping(value = "Timetable", method = RequestMethod.POST)
//    @RequestMapping(value = "Timetable", method = RequestMethod.GET)
    public String getUsers(@ModelAttribute Model model) {


        logger.debug("display all timetable list");
       return "Timetable";
    }


        @RequestMapping(value = "TimetableResult", method = RequestMethod.POST)
        public String getTimetable(@ModelAttribute Model model) {
            return "TimetableResult";
    }


    @RequestMapping(value = "/resultZ", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        logger.error("\n");
        logger.error("Hello world, logger. We are in POST method!");
//        greeting.setContent("After default we add something in post method, but value is still 0!");
        return "resultPage";
    }

    @RequestMapping(value = "/resultTT", method = RequestMethod.POST)
    public ModelAndView stationFiltered(@ModelAttribute StationDto station) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("timetableModel", timetableService.getAllRoutesThroughStationWithName(station.getStationName()));
        modelAndView.setViewName("TimetableResult");
        return modelAndView;
    }


//
//
//    class MyForm {
//        private String nameOfInstitution;
//
//        public String getNameOfInstitution() {
//            return nameOfInstitution;
//        }
//
//        public void setNameOfInstitution(String nameOfInstitution) {
//            this.nameOfInstitution = nameOfInstitution;
//        }
//    }



}

