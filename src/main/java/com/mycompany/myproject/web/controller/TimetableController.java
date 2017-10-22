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
       StationDto stdo = new StationDto();
        List<String> stationsList = new ArrayList<>();
        stationsList = timetableService.getAllStationsNames();
        model.addAttribute("someList", stationsList);

        model.addAttribute("station", stdo);
        model.addAttribute("timetableModel", timetableService.getAllTimetable());
        logger.info("Someone requests timetable");
        return "timetable";
    }




    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public @ResponseBody UserDto getUserInfo(@RequestParam String login) {

        UserDto user = new UserDto();
        if (user != null) {
        user = new UserDto(userService.getUserByLogin(login));
        }
        logger.info("getting information about user");
        return user;
    }

    @RequestMapping(value = "timetable", method = RequestMethod.POST)
    public String getUsers(@ModelAttribute Model model) {


        logger.debug("Discpaying timetable list");
       return "timetable";
    }

        @RequestMapping(value = "timetableResult", method = RequestMethod.POST)
        public String getTimetable(@ModelAttribute Model model) {
            return "timetableResult";
    }



    @RequestMapping(value = "/resultTT", method = RequestMethod.GET)
    public ModelAndView stationFiltered(@ModelAttribute StationDto station) {
        logger.debug("Filtering information about stations");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("timetableModel", timetableService.getAllRoutesThroughStationWithName(station.getStationName()));
        modelAndView.setViewName("timetableResult");
        return modelAndView;
    }





}


//class Response {
//
//    private int count;
//    private String text;
//
//    public int getCount() {
//        return count;
//    }
//    public void setCount(int count) {
//        this.count = count;
//    }
//    public String getText() {
//        return text;
//    }
//    public void setText(String text) {
//        this.text = text;
//    }
//}
//@RequestMapping(value = "/getCharNum", method = RequestMethod.GET)
//public @ResponseBody Response getCharNum(@RequestParam String text) {
//
//    Response result = new Response();
//
//    if (text != null) {
//        result.setText(text);
//        result.setCount(text.length());
//    }
//
//    return result;
//}