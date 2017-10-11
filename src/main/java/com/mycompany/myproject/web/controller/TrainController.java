package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.service.TrainService;
import com.mycompany.myproject.service.dto.TrainDto;
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
public class TrainController {

    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private DozerBeanMapper mapper;
//
    @Autowired
    private TrainService trainService;

    @Autowired
    private MessageSource ms;
    

    @RequestMapping(value = "/trainsList", method = RequestMethod.GET)
    public @ResponseBody List<TrainDto> usersList() {
        logger.debug("get json user list");
        return trainService.findAll();
    }



}    

 
