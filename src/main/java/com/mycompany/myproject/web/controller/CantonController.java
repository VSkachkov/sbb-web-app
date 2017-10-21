package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.service.svc.CantonService;
//import com.mycompany.myproject.dto.CantonDto;
import com.mycompany.myproject.dto.CantonDto;
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
public class CantonController {

    private static final Logger logger = LoggerFactory.getLogger(CantonController.class);

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private CantonService cantonService;

    @Autowired
    private MessageSource ms;
    
@RequestMapping(value = "/cantonsList", method = RequestMethod.GET)
public @ResponseBody
List<CantonDto> cantonsList() {
    logger.debug("get json cantons list");

    return cantonService.getAllCantons();
}

}    

 
