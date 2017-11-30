package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.dto.TrainChangeDto;
import com.mycompany.myproject.persist.entity.TrainChange;
import com.mycompany.myproject.service.svc.TrainChangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Scope("request")
public class ChangesController {
    private static final Logger logger = LoggerFactory.getLogger(CantonController.class);


    @Autowired
    TrainChangeService trainChangeService;

    @CrossOrigin
    @RequestMapping(value = "/getChanges", method = RequestMethod.GET)
    public @ResponseBody
    List<TrainChangeDto> getChanges() {
        logger.info("Web-server requests changes info");
        return trainChangeService.getChanges();
    }

    @CrossOrigin
    @RequestMapping(value = "/saveChange", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> saveChange(@RequestBody TrainChangeDto changeDto) {
        logger.info("Web-server updates/adds car to DB: " + changeDto.toString());
        boolean result = trainChangeService.saveChangeToDb(changeDto);
        if(result)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteChange", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> deleteChange(@RequestBody TrainChangeDto changeDto) {
        logger.info("Web-server requests procedure of carriage deleting: " + changeDto.toString());
        if(trainChangeService.deleteChangeFromDB(changeDto))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
