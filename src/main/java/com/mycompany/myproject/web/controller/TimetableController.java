package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.dto.TimetableDto;
import com.mycompany.myproject.service.svc.UserService;
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
    private UserService userService;


    @Autowired
    private TimetableService timetableService;

    @Autowired
    StationService stationService;


    @Autowired
    private MessageSource ms;


    @RequestMapping(value = "/timetable", method = RequestMethod.GET)
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
        return "timetable";
    }

    @RequestMapping(value = "/getCharNum", method = RequestMethod.GET)
    public @ResponseBody Response getCharNum(@RequestParam String text) {

        Response result = new Response();

        if (text != null) {
            result.setText(text);
            result.setCount(text.length());
        }

        return result;
    }


    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public @ResponseBody UserDto getCharNum(@RequestParam Long id) {

        UserDto user = new UserDto();
        if (user != null) {
        user = new UserDto(userService.getUserById(id));
        }

        return user;
    }

    @RequestMapping(value = "timetable", method = RequestMethod.POST)
//    @RequestMapping(value = "Timetable", method = RequestMethod.GET)
    public String getUsers(@ModelAttribute Model model) {


        logger.debug("display all timetable list");
       return "timetable";
    }


        @RequestMapping(value = "timetableResult", method = RequestMethod.POST)
        public String getTimetable(@ModelAttribute Model model) {
            return "timetableResult";
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
        modelAndView.setViewName("timetableResult");
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


class Response {

    private int count;
    private String text;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
