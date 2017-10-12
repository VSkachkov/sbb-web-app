package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.service.TimetableService;
import com.mycompany.myproject.service.dto.TimetableDto;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Scope("request")
public class TimetableController {

    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private DozerBeanMapper mapper;


    @Autowired
    private TimetableService timetableService;

    @Autowired
    private MessageSource ms;
    
    

    @RequestMapping(value = "/Timetable", method = RequestMethod.GET)
    public ModelAndView goToTimetable() {
        timetableService.findByStationName("Zurich");
        return new ModelAndView("Timetable");
    }

}

 
