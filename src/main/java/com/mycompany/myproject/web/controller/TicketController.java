package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.dto.TrainsAttribute;
import com.mycompany.myproject.dto.TrainsForm;
import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.service.svc.TicketService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.service.svc.TrainService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@Scope("request")
@SessionAttributes("user")
public class TicketController {

    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private DozerBeanMapper mapper;


    @Autowired
    private TicketService ticketService;

    @Autowired
    TrainService trainService;

    @Autowired
    TimetableService timetableService;


    @PostMapping(value="buyTicketResult")
    public
    String showBuyingTicketResult(Model model, @ModelAttribute PassengerForm passengerForm){




        String result = ticketService.launchBuyingProcedure(passengerForm);
        logger.info("Launching buying procedure");
        logger.info("Type of date" + passengerForm.getTravelDate().getClass().toString());
        model.addAttribute("result", result);
        return "buyTicketResult";
    }


    @RequestMapping(value = "/buyTicket", method = RequestMethod.GET)
    public String setConditionsforTrainsBetweenStations(Model model,
                                                        HttpSession session) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_CLIENT"))
        return "404";

        model.addAttribute("trainsForm", new TrainsForm());
        logger.info("We are in GET method!");
        return "trainsForTicket";
    }



    @RequestMapping(value = "/resultTrainsForTicket", method = RequestMethod.POST)
    public String getStationFilteredForTicket(Model model, @ModelAttribute("trainsForm") TrainsForm trainsForm,
                                              HttpSession session) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        if (!userDto.getRole().equals("ROLE_CLIENT"))
            return "404";
        List<Long> trainsList = new ArrayList<>();
        PassengerForm passengerForm = new PassengerForm();
        model.addAttribute("trainsForm",trainsForm );
        model.addAttribute("TravelDate", trainsForm.getTravelDate());
        model.addAttribute("StationFrom", trainsForm.getStationFrom());
        model.addAttribute("StationTo", trainsForm.getStationTo());


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
        return "trainsResultForTicket";
    }
}
