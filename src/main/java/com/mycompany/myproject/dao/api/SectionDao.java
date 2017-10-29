package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Section;

import java.util.List;

public interface SectionDao {
    List<Section> getAllSections();
    List<Section> getSectionsByStationId(Long stationId);

}
