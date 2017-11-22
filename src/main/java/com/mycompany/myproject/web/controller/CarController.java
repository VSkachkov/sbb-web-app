package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.CarDto;
import com.mycompany.myproject.service.svc.CarService;
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
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CantonController.class);

    @Autowired
    CarService carService;

    @CrossOrigin
    @RequestMapping(value = "/getCars", method = RequestMethod.GET)
    public @ResponseBody
    List<CarDto> getCars() {
        logger.info("Web-server requests carriages info");
        return carService.getAllCars();
    }

    @CrossOrigin
    @RequestMapping(value = "/saveCar", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> saveCar(@RequestBody CarDto carDto) {
        logger.info("Web-server updates/adds car to DB: " + carDto.toString());
        boolean result = carService.saveCarToDb(carDto);
        if(result)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> deleteCar(@RequestBody CarDto carDto) {
        logger.info("Web-server requests procedure of carriage deleting: " + carDto.toString());
        if(carService.deleteCarFromDB(carDto))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
}
