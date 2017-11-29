package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.SectionDto;
import com.mycompany.myproject.dto.TicketWebDto;
import com.mycompany.myproject.service.svc.SectionService;
import com.mycompany.myproject.service.svc.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Scope("request")
public class SectionController {

    private static final Logger logger = LoggerFactory.getLogger(SectionController.class);

    @Autowired
    private StationService stationService;

    @Autowired
    private SectionService sectionService;

    @CrossOrigin
    @RequestMapping(value = "/sectionsList", method = RequestMethod.GET)
    public @ResponseBody
    List<SectionDto> stationsList() {
        logger.info("Web-server requests sections list");
        return sectionService.getAllSectionsDtos();//.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/admin/saveSection", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> saveSection(@RequestBody SectionDto sectionDto) {
        logger.info("Web-server updates/adds section: " + sectionDto.toString());
        if (sectionService.saveSectionToDb(sectionDto))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value = "/admin/deleteSection", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> deleteStation(@RequestBody SectionDto sectionDto) {
        logger.info("Web-server requests procedure of section deleting: " + sectionDto.toString());
        Long sectionId = sectionDto.getSectionId();
        if (sectionId == null )
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        else
        {
            if(sectionService.getSectionById(sectionId)!=null)
            sectionService.deleteSection(sectionId);
            if(sectionService.getSectionById(sectionId)==null)
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.OK);

    }


}
