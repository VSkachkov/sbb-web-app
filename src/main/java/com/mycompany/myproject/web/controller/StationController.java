package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.persist.entity.Station;
import com.mycompany.myproject.service.svc.StationService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Scope("request")
public class StationController {

    private static final Logger logger = LoggerFactory.getLogger(StationController.class);

    private DozerBeanMapper mapper;


    @Autowired
    private StationService stationService;

    @Autowired
    private MessageSource ms;


    @CrossOrigin
        @RequestMapping(value = "/stationsList", method = RequestMethod.GET)
    public @ResponseBody List<StationDto> stationsList() {
        logger.info("someone requests stations list");
        return stationService.getAllStationDtos();//.findAll();
    }



    @CrossOrigin
    @RequestMapping(value = "/saveStation", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> getUsersList(@RequestBody StationDto stationDto, HttpServletResponse response) {
        logger.info("Web-server updates/adds station: "+ stationDto.toString());
        ResponseEntity myResponse;
        if(stationService.isStationNameInDb(stationDto.getStationName())){
            stationService.updateStation(stationDto);
            return new ResponseEntity(HttpStatus.OK);
        }
        else
            if(stationService.isStationIdInDb(stationDto.getStationId())){
                stationService.updateStation(stationDto);
                return new ResponseEntity(HttpStatus.OK);
            }
            else
            {
                stationService.addNewStationByDto(stationDto);
                return new ResponseEntity(HttpStatus.OK);
            }
    }
}    

 
