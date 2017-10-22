package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.service.svc.TicketService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Scope("request")
public class TicketController {

    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private DozerBeanMapper mapper;


    @Autowired
    private TicketService ticketService;


    @PostMapping(value="buyTicketResult")
    public
    String showBuyingTicketResult(Model model, @ModelAttribute PassengerForm passengerForm){




        String result = ticketService.launchBuyingProcedure(passengerForm);
        logger.info("Launching buying procedure");
        logger.info("Type of date" + passengerForm.getTravelDate().getClass().toString());
        model.addAttribute("result", result);
        return "buyTicketResult";
    }
}
