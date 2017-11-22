package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.service.svc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URI;
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
    private UserService userService;


    @Autowired
    private MessageSource ms;

    @GetMapping(value = "/manager")
    public String goManagerPage(HttpSession session, @ModelAttribute UserDto user
    ) {
        logger.info("user tries to log in as admin");
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (userDto.getRole().equals("ROLE_ADMIN"))
        return "managerPage";
        else return "404";
    }

    @GetMapping(value = "/managerPage")
    public String goToManagerPage(HttpSession session, @ModelAttribute UserDto user
    ) {
        logger.info("user tries to log in as admin");
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (userDto.getRole().equals("ROLE_ADMIN"))
            return "managerPage";
        else return "404";
    }

    @PostMapping(value = "/addTrainResult")
    public  String addTrainForm(HttpSession session,
                                             @ModelAttribute TrainDto trainDto,
                                             @ModelAttribute UserDto user,
                                Model model) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (userDto.getRole().equals("ROLE_ADMIN"))
        {
            logger.info("manager requests list of trains in database");
            //TODO Fix problem with checkbox in bootstrap
        trainDto.setDepartMon(true);
        trainDto.setDepartTue(true);
        trainDto.setDepartWed(true);
        trainDto.setDepartThu(true);
        trainDto.setDepartFri(true);
        trainDto.setDepartSat(true);
        trainDto.setDepartSun(true);

        managerService.addTrainToDB(trainDto);
        model.addAttribute("addTrainResult",  "Train was added to database");
            return "mAddTrainResult";}

        else return "404";
    }



    @RequestMapping(value = "/addTrain", method = RequestMethod.GET)
    public String addTrain(Model model, HttpSession session){
        logger.info("manager adds train to database");
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        model.addAttribute("trainDto", new TrainDto());
        return "mAddTrainPage";
    }


    @RequestMapping(value="getReserves", method = RequestMethod.GET)
    public String getReserves(Model model,
                              HttpSession session){
        logger.info("manager checks passengers onboard");
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        List<Long> trainsList = new ArrayList<>();
        Long trainNumberAttribute = 0L;
        Date travelDate = new Date(0L);
        model.addAttribute("passengerForm", new PassengerForm());


        return "mGetReservesPage";
    }

    @PostMapping(value="/addReservesResult")
        public  ModelAndView showReserveResult(@ModelAttribute PassengerForm passengerForm,
                                               HttpSession session){
        logger.info("manager checks registered passengers depending on the train");
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



    @RequestMapping(value = "/addStation", method = RequestMethod.GET)
    public String addStation(Model model,
                             HttpSession session){
        logger.info("manager adds station to database");
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        List <String> cantonsList = new ArrayList<>();
        cantonsList = managerService.getAllCantonsNames();

        model.addAttribute("cantonsList", cantonsList);
        model.addAttribute("stationForm", new StationForm());
        return "mAddStationPage";
    }

    @PostMapping(value = "/addStationResult")
    public  String addStationForm(@ModelAttribute StationForm stationForm,
                                             HttpSession session,
                                  Model model) {
        logger.info("manager adds station to database. Result of adding station to DB");
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        model.addAttribute("stationAddResult", "Station was added to database");
        try {
            managerService.addStationToDB(stationForm);
        }
        catch (Exception e){
            model.addAttribute("stationAddResult", "Station was not added to database");
        }


        return "mAddStationResult";
    }

    @RequestMapping(value = "/getTrains", method = RequestMethod.GET)
    public String getTrains(Model model,
                            HttpSession session) {
        logger.info("manager gets list of trains in database");
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_ADMIN"))
        { return "home";}

        List <TrainDto> trainDtos = managerService.getTrainsForManagers();
        model.addAttribute("timetableModel",trainDtos);
        return "mGetTrainsPage";
    }

    @CrossOrigin
    @RequestMapping(value = "/addStationRest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> stationInfo(@RequestBody String msg, HttpServletResponse response) {
        msg.toString();
        ResponseEntity myResponse = new ResponseEntity(HttpStatus.OK);
        return myResponse;
    }



}
