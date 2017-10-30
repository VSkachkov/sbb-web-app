package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Section;

import java.util.List;

public interface SectionService {

    List<Section> getAllSections();
    List<Section> getSectionsByStationId(Long stationId);
    boolean addNewSectionByParams(Long stationOneId, Long stationTwoId, float length);
    boolean addNewSection(Section section);

    }

