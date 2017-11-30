package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.SectionDto;
import com.mycompany.myproject.persist.entity.Section;

import java.util.List;

public interface SectionService {

    /**
     * finds all sections in DB
     *
     * @return sections
     */
    List<Section> getAllSections();

    /**
     * deletes section by it's ID
     * @param sectionId
     */
    void deleteSection(Long sectionId);

    /**
     * updates section length
     * @param sectionId
     * @param length
     */
    void updateLength(Long sectionId, float length);

    /**
     * gets sections by station ID
     * @param stationId station id
     * @return sections
     */
    List<Section> getSectionsByStationId(Long stationId);

    /**\
     * finds sections by station id
     * @param stationId station ID
     * @return sections
     */
    List<Section> getSectionsByStationToId(Long stationId);

    /**
     * gets sections by station FROM id
     * @param stationId station ID
     * @return sections
     */
    List<Section> getSectionsByStationFromId(Long stationId);

    /**
     * provides section DTOs by station ID
     * @param stationId station ID
     * @return section DTOs
     */
    List<SectionDto> getSectionsDtosByStationId(Long stationId);

    /**
     * gets all sections DTOs
     * @return
     */
    List<SectionDto> getAllSectionsDtos();

    /**
     * adds new section to DB
     * @param stationOneId
     * @param stationTwoId
     * @param length
     * @return true if OK
     */
    boolean addNewSectionByParams(Long stationOneId, Long stationTwoId, float length);

    /**
     * adds new section to DB
     * @param section
     * @return true if OK
     */
    boolean addNewSection(Section section);

    /**
     * finds section  by ID
     * @param sectionId
     * @return
     */
    Section getSectionById(Long sectionId);

    /**
     * saves section to DB
     * @param sectionDto section DTO
     * @return true if OK
     */
    boolean saveSectionToDb(SectionDto sectionDto);

    /**
     * find section between station
     * @param fromId station from id
     * @param toId station to id
     * @return Section
     */
    Section getSectionByFromAndToIds(Long fromId, Long toId);
}

