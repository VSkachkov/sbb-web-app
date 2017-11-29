package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.RouteDto;
import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.service.svc.RouteService;
import com.mycompany.myproject.service.svc.SectionService;
import com.mycompany.myproject.service.svc.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Controller
@Scope("request")
public class RouteController {

    private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    RouteService routeService;

    @Autowired
    SectionService sectionService;

    @Autowired
    StationService stationService;

    @CrossOrigin
    @RequestMapping(value = "/getRoutes", method = RequestMethod.GET)
    public @ResponseBody
    List<RouteDto> getRoutes() {
        logger.info("Web-server requests list of routes");
        return routeService.getAllRoutesDto();//.findAll();
    }

    @CrossOrigin
    @RequestMapping(  value = "/sections/{stationId}",
            method = RequestMethod.GET)
    public  @ResponseBody List <StationDto> getAvailableStations(@PathVariable("stationId") Long stationFromId ) {

        List <Section> sections = sectionService.getSectionsByStationFromId(stationFromId);
        List <StationDto> stationToDtos = new ArrayList<>();
        for (Section section :
                sections) {
            stationToDtos.add(new StationDto(stationService.getStationById(section.getStationToId().getStationId())));
        }
        return stationToDtos;
    }


    @CrossOrigin
    @RequestMapping(value = "/admin/saveRoute", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> saveRoute(@RequestBody RouteDto routeDto) {
        logger.info("Web-server adds new Route: " + routeDto.toString());
        if (routeService.addRouteFromWeb(routeDto))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value = "/admin/deleteRoute", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> deleteRoute(@RequestBody RouteDto routeDto) {
        logger.info("Web-server requests procedure of routes deleting: " + routeDto.toString());
        if(routeService.deleteRouteFromWeb(routeDto))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


}
