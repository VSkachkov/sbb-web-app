package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.service.dto.StationDto;
import com.mycompany.myproject.service.dto.StationForm;
import com.mycompany.myproject.service.dto.TrainDto;
import com.mycompany.myproject.service.dto.TrainsForm;
import com.mycompany.myproject.service.svc.CantonService;
import com.mycompany.myproject.service.svc.ManagerService;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("/management")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private ManagerService managerService;

    @Autowired
    StationService stationService;

    @Autowired
    CantonService cantonService;

    @Autowired
    TimetableService timetableService;

    @Autowired
    private MessageSource ms;

    @GetMapping(value = "/managerLink")
    public String goManagerPage(
    ) {
        return "managerPage";
    }

    @PostMapping(value = "/addTrainResultLink")
    public @ResponseBody String addTrainForm(@ModelAttribute TrainDto trainDto
    ) { //TODO Fix problem with checkbox in bootstrap
        trainDto.setDepartMon(true);
        trainDto.setDepartTue(true);
        trainDto.setDepartWed(true);
        trainDto.setDepartThu(true);
        trainDto.setDepartFri(true);
        trainDto.setDepartSat(true);
        trainDto.setDepartSun(true);

        managerService.addTrainToDB(trainDto);
//        logger.error("We are in POST method!");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("TrainsResult");

        return "Train was added to DB";
    }



    @RequestMapping(value = "/addTrainLink", method = RequestMethod.GET)
    public String addTrain(Model model){
        model.addAttribute("trainDto", new TrainDto());
        return "mAddTrainPage";
    }

    @RequestMapping(value = "/addStationLink", method = RequestMethod.GET)
    public String addStation(Model model){
        List <String> cantonsList = new ArrayList<>();
        cantonsList = cantonService.getAllCantonsNames();

        model.addAttribute("cantonsList", cantonsList);
        model.addAttribute("stationForm", new StationForm());
        return "mAddStationPage";
    }




    @PostMapping(value = "/addStationResultLink")
    public @ResponseBody String addTrainForm(@ModelAttribute StationForm stationForm
    ) {
        managerService.addStationToDB(stationForm);


        return "Station was added to DB";
    }

//    @GetMapping(value = "/addStationLink")
//    public String addStation(Model model
//    ) {
//        model.addAttribute("greeting", new Greeting());
//        StationDto stdo = new StationDto();
//
//
//        List<String> stationsList = new ArrayList<>();
//        stationsList = stationService.getAllStationsNames();
////        model.addAttribute("myform", new MyForm());
//        model.addAttribute("someList", stationsList);
//
//        model.addAttribute("station", stdo);
//        model.addAttribute("timetableModel", timetableService.getAllTimetable());
//        logger.error("We are in GET method!");
//        return "mAddStationPage";
//    }
//
//    @PostMapping(value = "/mResultAddStation")
//    public @ResponseBody String addStationResult(Model model, @ModelAttribute ("station") StationForm stationForm)
//     {
//
//
//        return "OK";
//    }


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
