package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.service.dao.api.TimetableDao;
import com.mycompany.myproject.service.dto.StationDto;
import com.mycompany.myproject.service.dto.TrainsForm;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.service.svc.TrainService;
import com.mycompany.myproject.service.dto.TrainDto;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public String greetingForm(Model model) {
//        model.addAttribute("greeting", new Greeting());
        StationDto stdo = new StationDto();

        model.addAttribute("trainsForm", new TrainsForm());
        logger.error("We are in GET method!");
        return "Trains";
    }

    @RequestMapping(value = "/resultTrainsLink", method = RequestMethod.POST)
    public ModelAndView stationFiltered(@ModelAttribute TrainsForm trainsForm) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("timetableModel", timetableService.getAllRoutesThroughStationWithName(trainsForm.getStationTo()));
        modelAndView.addObject("timetableModel",
                timetableService.getTimetableBetweenStations(trainsForm.getStationFrom(), trainsForm.getStationTo(),
                        trainsForm.getEarlyTime(), trainsForm.getLateTime()));
        modelAndView.setViewName("TrainsResult");
        return modelAndView;
    }


}    

 
