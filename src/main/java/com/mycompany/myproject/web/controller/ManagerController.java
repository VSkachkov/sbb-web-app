package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.service.dto.StationDto;
import com.mycompany.myproject.service.dto.TrainDto;
import com.mycompany.myproject.service.dto.TrainsForm;
import com.mycompany.myproject.service.svc.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("/management")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private ManagerService managerService;

    @Autowired
    private MessageSource ms;

    @GetMapping(value = "/managerLink")
    public String goManagerPage(
    ) {


        return "managerPage";
    }

    @RequestMapping(value = "/addTrainLink", method = RequestMethod.GET)
    public String addTrain(Model model){
//        model.addAttribute("greeting", new Greeting());

        model.addAttribute("trainsForm", new TrainsForm());
        model.addAttribute("trainDto", new TrainDto());
//        logger.error("We are in GET method!");
        return "mAddTrainPage";
    }

    @PostMapping(value = "/addTrainResultLink")
    public ModelAndView addTrainForm(@ModelAttribute TrainDto trainDto
    ) {
        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.addObject("timetableModel", timetableService.getAllRoutesThroughStationWithName(trainsForm.getStationTo()));
//        modelAndView.addObject("timetableModel",
//                timetableService.getTimetableBetweenStations(trainsForm.getStationFrom(), trainsForm.getStationTo(),
//                        trainsForm.getEarlyTime(), trainsForm.getLateTime()));
        modelAndView.setViewName("TrainsResult");
        return modelAndView;
    }




    @GetMapping(value = "/addStationLink")
    public String addStation(
    ) {


        return "mAddStationPage";
    }

    @GetMapping(value = "/getReservesLink")
    public String getReserves(
    ) {


        return "mGetReservePage";
    }

    @RequestMapping(value = "/getTrainsLink", method = RequestMethod.GET)
    public String getTrains(Model model
    ) {
        List <TrainDto> trainDtos = managerService.getTrainsForManagers();
//        ModelAndView modelAndView = new ModelAndView("mGetTrainsPage" );
////        modelAndView.setViewName("");
//        modelAndView.addObject("timetableModel",trainDtos  );
        model.addAttribute("timetableModel",trainDtos);

//        List<TrainDto> ltdto = managerService.getTrainsForManagers();
        return "mGetTrainsPage";
    }

}
