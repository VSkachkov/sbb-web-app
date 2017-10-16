package com.mycompany.myproject.service.dao.api;

import com.mycompany.myproject.persist.entity.Section;
import java.util.List;

public interface SectionDao {
    List<Section> getAllSections();
    void addNewSection(Section section);
    void removeSection(Long id);
    Section getSectionById(Long id);

}
