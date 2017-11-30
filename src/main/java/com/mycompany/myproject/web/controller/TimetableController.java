package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.service.svc.StationService;
import com.mycompany.myproject.service.svc.TimetableService;
import com.mycompany.myproject.dto.StationDto;
import com.mycompany.myproject.dto.TimetableDto;
import com.mycompany.myproject.service.svc.UserService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("request")
public class TimetableController {

    private static final Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private UserService userService;


    @Autowired
    private TimetableService timetableService;

    @Autowired
    StationService stationService;

}
