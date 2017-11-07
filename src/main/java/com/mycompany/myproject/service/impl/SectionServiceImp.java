package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.SectionDao;
import com.mycompany.myproject.dto.SectionDto;
import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.service.svc.SectionService;
import com.mycompany.myproject.service.svc.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<Section> getSectionsByStationToId(Long stationId) {
        return sectionDao.getSectionsByStationToId(stationId);
    }

    @Override
    public List<Section> getSectionsByStationFromId(Long stationId) {
        return sectionDao.getSectionsByStationFromId(stationId);
    }

    @Override
    public List<SectionDto>getSectionsDtosByStationId(Long stationId){
        List <Section> sections = getSectionsByStationId(stationId);

        List <SectionDto> sectionsDto = new ArrayList<>();
        for (Section section:
             sections) {
            sectionsDto.add(new SectionDto(section));
        }
        return sectionsDto;
    }

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
    }

    @Override
    public boolean addNewSection(Section section){
        sectionDao.addNewSection(section);
        return true;
    }

    @Override
    public Section getSectionById(Long sectionId) {
        return sectionDao.getSectionById(sectionId);
    }

}