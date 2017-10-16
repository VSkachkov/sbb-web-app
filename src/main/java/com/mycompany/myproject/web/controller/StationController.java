package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.service.svc.StationService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("request")
public class StationController {

    private static final Logger logger = LoggerFactory.getLogger(StationController.class);


//    @Autowired
private DozerBeanMapper mapper;
//    @Autowired
//    private UserService userService;

    @Autowired
    private StationService stationService;

    @Autowired
    private MessageSource ms;


//    @RequestMapping(value = "/stationsList", method = RequestMethod.GET)
//    public @ResponseBody String stationsList() {
//        StationDto stdto = new StationDto();
//        stdto.s
//        logger.debug("get json stations list");
//        return "Hello World";
//    }

        @RequestMapping(value = "/stationsList", method = RequestMethod.GET)
    public @ResponseBody List<Station> stationsList() {
        logger.debug("get json stations list");
        return stationService.getAllStations();//.findAll();
    }
}    

 
