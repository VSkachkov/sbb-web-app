package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.service.svc.TicketService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.service.svc.TrainService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;
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


    @CrossOrigin
    @RequestMapping(value = "/buyWebTicket", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> buyWebTicket(@RequestBody TicketWebDto ticketWebDto) {
        logger.info("Web-server requests buying ticket procedure: " + ticketWebDto.toString());
        Date travelDate = new Date(ticketWebDto.getTravelDateL());
        Date birthday = new Date(ticketWebDto.getBirthdayL());
        ticketWebDto.setTravelDate(travelDate);
        ticketWebDto.setBirthday(birthday);
        if (ticketService.buyWebTicket(ticketWebDto))
            return new ResponseEntity(HttpStatus.OK);
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/item-template.html", method = RequestMethod.GET)
    public @ResponseBody
    String showTemplate (){
        return "    <div>\n" +
                "    <img ng-src=\"{{slideItem.src}}\" >\n" +
                "   </div>";
    }



}
