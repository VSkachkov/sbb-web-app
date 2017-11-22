package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.RateAgeDto;
import com.mycompany.myproject.dto.RateSeasonDto;
import com.mycompany.myproject.persist.entity.RateAge;
import com.mycompany.myproject.persist.entity.RateDaysBefore;
import com.mycompany.myproject.persist.entity.RateSeatsLeft;
import com.mycompany.myproject.service.svc.RatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("request")
public class RatesController {
    private static final Logger logger = LoggerFactory.getLogger(RatesController.class);

    @Autowired
    RatesService ratesService;

    @CrossOrigin
    @RequestMapping(value = "/ageRates", method = RequestMethod.GET)
    public @ResponseBody
    List<RateAgeDto> getAgeRates() {
        logger.info("Web-server requests age rates");
        return ratesService.getAllAgeRates();
    }

    @CrossOrigin
    @RequestMapping(value = "/daysBeforeRates", method = RequestMethod.GET)
    public @ResponseBody
    List<RateDaysBefore> getdDaysBeforeRates() {
        logger.info("Web-server requests days before  rates");
        return ratesService.getAllDaysBeforeRates();
    }

    @CrossOrigin
    @RequestMapping(value = "/capacityRates", method = RequestMethod.GET)
    public @ResponseBody
    List<RateSeatsLeft> getCapacityRates() {
        logger.info("Web-server requests capacity rates");
        return ratesService.getAllSeatsLeftRates();
    }

    @CrossOrigin
    @RequestMapping(value = "/seasonRates", method = RequestMethod.GET)
    public @ResponseBody
    List<RateSeasonDto> getSeasonRates() {
        logger.info("Web-server requests age rates");
        return ratesService.getAllSeasonRates();
    }
}
