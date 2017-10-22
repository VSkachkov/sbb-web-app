package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.service.svc.CantonService;
import com.mycompany.myproject.service.svc.ManagerService;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
@Scope("request")
//@RequestMapping("/management")
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
    public String goManagerPage(HttpSession session, @ModelAttribute UserDto user
    ) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (userDto.getRole().equals("ROLE_ADMIN"))
        return "managerPage";
        else return "404";
    }

    @PostMapping(value = "/addTrainResultLink")
    public @ResponseBody String addTrainForm(HttpSession session,
                                             @ModelAttribute TrainDto trainDto,
                                             @ModelAttribute UserDto user) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (userDto.getRole().equals("ROLE_ADMIN"))
        {
        //TODO Fix problem with checkbox in bootstrap
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

        return "Train was added to DB";}
        else return "404";
    }



    @RequestMapping(value = "/addTrainLink", method = RequestMethod.GET)
    public String addTrain(Model model, HttpSession session){
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        model.addAttribute("trainDto", new TrainDto());
        return "mAddTrainPage";
    }

    @RequestMapping(value = "/addStationLink", method = RequestMethod.GET)
    public String addStation(Model model,
                             HttpSession session){
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        List <String> cantonsList = new ArrayList<>();
        cantonsList = cantonService.getAllCantonsNames();

        model.addAttribute("cantonsList", cantonsList);
        model.addAttribute("stationForm", new StationForm());
        return "mAddStationPage";
    }

    @RequestMapping(value="getReservesLink", method = RequestMethod.GET)
    public String getReserves(Model model,
                              HttpSession session){
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        List<Long> trainsList = new ArrayList<>();
        Long trainNumberAttribute = 0L;
        Date travelDate = new Date(0L);
        model.addAttribute("passengerForm", new PassengerForm());


        return "mGetReservesPage";
    }

    @PostMapping(value="/addReservesResultLink")
        public  ModelAndView showReserveResult(@ModelAttribute PassengerForm passengerForm,
                                               HttpSession session){
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return new ModelAndView("home");}

        Date travelDate = passengerForm.getTravelDate();
        Long trainNumber = passengerForm.getTrainNumber();
        ModelAndView modelAndView = new ModelAndView();
        List<PassengerForm> passengers = managerService.getPassengers(trainNumber, travelDate);

        modelAndView.addObject("passengers", passengers);
        modelAndView.setViewName("mShowReserveResult");

        return modelAndView;
    }




    @PostMapping(value = "/addStationResultLink")
    public @ResponseBody String addTrainForm(@ModelAttribute StationForm stationForm,
                                             HttpSession session) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        managerService.addStationToDB(stationForm);


        return "Station was added to DB";
    }

    @RequestMapping(value = "/getTrainsLink", method = RequestMethod.GET)
    public String getTrains(Model model,
                            HttpSession session) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        List <TrainDto> trainDtos = managerService.getTrainsForManagers();
//        ModelAndView modelAndView = new ModelAndView("mGetTrainsPage" );
////        modelAndView.setViewName("");
//        modelAndView.addObject("timetableModel",trainDtos  );
        model.addAttribute("timetableModel",trainDtos);

//        List<TrainDto> ltdto = managerService.getTrainsForManagers();
        return "mGetTrainsPage";
    }

}
