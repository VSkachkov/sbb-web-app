package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.SectionDao;
import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.service.svc.SectionService;
import com.mycompany.myproject.service.svc.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SectionServiceImp implements SectionService {

    @Autowired
    SectionDao sectionDao;

    @Autowired
    StationService stationService;

    @Override
    public List<Section> getAllSections(){
        return sectionDao.getAllSections();
    }

    @Override
    public List<Section>getSectionsByStationId(Long stationId){
        return sectionDao.getSectionsByStationId(stationId);
    }

    @Override
    public List<SectionDto>

    @Override
    public boolean addNewSectionByParams(Long stationOneId, Long stationTwoId, float length){
        Section sectionOneDirection = new Section();
        sectionOneDirection.setStationFromId(stationService.getStationById(stationOneId));
        sectionOneDirection.setStationToId(stationService.getStationById(stationTwoId));
        sectionOneDirection.setLength(length);
        this.addNewSection(sectionOneDirection);

        Section sectionOppositeDirection = new Section();
        sectionOppositeDirection.setStationFromId(stationService.getStationById(stationTwoId));
        sectionOppositeDirection.setStationToId(stationService.getStationById(stationOneId));
        sectionOppositeDirection.setLength(length);
        this.addNewSection(sectionOppositeDirection);

        return true;

//        return sectionDao.addNewSectionByParams(stationOneId, stationTwoId, length);
    }

    @Override
    public boolean addNewSection(Section section){
        sectionDao.addNewSection(section);
        return true;
    }

}
