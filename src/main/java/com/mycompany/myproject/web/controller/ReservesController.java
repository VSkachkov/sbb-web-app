package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.service.svc.ReserveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("request")
public class ReservesController {

    private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    ReserveService reserveService;

    @CrossOrigin
    @RequestMapping(value = "/getTickets", method = RequestMethod.GET)
    public @ResponseBody
    List<TicketWebDto> getTicketsReserves() {

        logger.info("Web-server requests list of tickets");
        return reserveService.getAllJourneys();
    }


    @CrossOrigin
    @RequestMapping(value = "/getStatisticsByLastMonth", method = RequestMethod.GET)
    public @ResponseBody
    List<Long> getStatisticsByLastMonth() {

        logger.info("Web-server requests statictics");
        return reserveService.getStatisticsByLastMonth();
    }


    @CrossOrigin
    @RequestMapping(value = "/getReservesByParams/{trainId}/{travelDateL}", method = RequestMethod.GET)
    public @ResponseBody
    List<TicketWebDto> getReservesByParams(@PathVariable Long trainId, @PathVariable Long travelDateL) {

        logger.info("Web-server requests reserves by params: "+trainId.toString()+travelDateL.toString());
        return reserveService.getTicketsByParams(trainId, travelDateL);
    }



}
