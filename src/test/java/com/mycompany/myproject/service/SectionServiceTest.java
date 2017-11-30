package com.mycompany.myproject.service;


import com.mycompany.myproject.config.JPAConfig;
import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.SectionDto;
import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.service.svc.SectionService;
import com.mycompany.myproject.service.svc.StationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})

public class SectionServiceTest {

    @Autowired
    SectionService sectionService;

    @Autowired
    StationService stationService;

    @Test
    public void testGetAllSections(){
        List<Section> sections = sectionService.getAllSections();
        Assert.assertTrue(!sections.isEmpty());

    }

    @Test
    public void testAddNewSections(){
        sectionService.addNewSectionByParams(13L, 38L, 27.5f);
        Assert.assertTrue(sectionService.getAllSections().size()>11);
    }

    @Test
    public void testGetSectionsDtosByStationId(){
        List <SectionDto> sectionsDtos = sectionService.getSectionsDtosByStationId(13L);
        Assert.assertTrue(!sectionsDtos.isEmpty());
    }


}
