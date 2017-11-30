package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.SectionDto;
import com.mycompany.myproject.persist.entity.Section;

import java.util.List;

public interface SectionService {

    List<Section> getAllSections();

    void deleteSection(Long sectionId);

    void updateLength(Long sectionId, float length);

    List<Section> getSectionsByStationId(Long stationId);

    List<Section> getSectionsByStationToId(Long stationId);

    List<Section> getSectionsByStationFromId(Long stationId);

    List<SectionDto> getSectionsDtosByStationId(Long stationId);

    List<SectionDto> getAllSectionsDtos();

    boolean addNewSectionByParams(Long stationOneId, Long stationTwoId, float length);

    boolean addNewSection(Section section);

    Section getSectionById(Long sectionId);

    boolean saveSectionToDb(SectionDto sectionDto);

    Section getSectionByFromAndToIds(Long fromId, Long toId);
}

