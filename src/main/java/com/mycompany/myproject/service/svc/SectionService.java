package com.mycompany.myproject.service.svc;


import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.service.dto.SectionDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SectionService// extends GenericService<Station, StationDto, Long>
{

    List<SectionDto> getAllSections();
    void addNewSection(Section section);
    void removeSection(Long id);
    Section getSectionById(Long id);



}
