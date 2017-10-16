package com.mycompany.myproject.web.controller;


import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.service.dto.SectionDto;
import com.mycompany.myproject.service.svc.SectionService;
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
public class SectionController {

    private static final Logger logger = LoggerFactory.getLogger(CantonController.class);

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private MessageSource ms;

    @RequestMapping(value = "/sectionsList", method = RequestMethod.GET)
    public @ResponseBody
    Section sectionsList() {
        logger.debug("get json sections list");

        return sectionService.getSectionById(1L);
    }
}
