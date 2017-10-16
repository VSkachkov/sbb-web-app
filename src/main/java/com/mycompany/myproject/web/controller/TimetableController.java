package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.service.svc.CantonService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.service.dto.StationDto;
import com.mycompany.myproject.service.dto.TimetableDto;
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

import java.util.List;

@Controller
@Scope("request")
public class TimetableController {

    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private DozerBeanMapper mapper;


    @Autowired
    private CantonService cantonService;

    @Autowired
    private TimetableService timetableService;


    @Autowired
    private MessageSource ms;

    Greeting gr = new Greeting(3, "Bye!");
//    @RequestMapping(value = "/Timetable", method = RequestMethod.GET)
//    public ModelAndView goToTimetable() {
//        ModelAndView timetable = new ModelAndView();
//        return timetable;
//    }

//    @RequestMapping(value = "/timetableList", method = RequestMethod.GET)
//    public @ResponseBody
//    List<TimetableDto> timetableList() {
//        logger.debug("get json user list");
//        return timetableService.findAll();
//    }

    @RequestMapping(value = "/timetableList", method = RequestMethod.GET)
    public @ResponseBody
    List<TimetableDto> timetableList() {
        logger.debug("get json user list");
        return timetableService.getAllTimetable();
//        return timetableService.getAllRoutesThroughStationWithId(2L);
//        return timetableService.getAllRoutesThroughStationWithName("Bern");
    }

    @RequestMapping(value = "/Timetable", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        StationDto stdo = new StationDto();

        model.addAttribute("station", stdo);
        model.addAttribute("timetableModel", timetableService.getAllTimetable());
//        model.addAttribute("timetableModel", timetableService.getAllRoutesThroughStationWithName("Bern"));
//        model.addAttribute("timetableModel", timetableService.getAllRoutesThroughStationWithName(stdo.getStationName()));
        logger.error("We are in GET method!");
        return "Timetable";
    }


    @RequestMapping(value = "Timetable", method = RequestMethod.POST)
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

//    String stationSubmit() {
//        Model model;
//        logger.error("\n");
//        logger.error("Hello world, logger. We are in stationSubmit method!");
//        model.addAttribute("timetableModel", timetableService.getAllRoutesThroughStationWithName(station.getStationName()));
//        logger.error("StationName result is"+station.getStationName());
//
////        greeting.setContent("After default we add something in post method, but value is still 0!");
//        return "TimetableResult";
//    }



    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*как только на index.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/demo/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", user);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }


}

 
