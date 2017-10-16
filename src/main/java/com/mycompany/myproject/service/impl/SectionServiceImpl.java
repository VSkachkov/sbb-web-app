package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.persist.entity.Section;
import com.mycompany.myproject.service.dao.api.SectionDao;
import com.mycompany.myproject.service.dto.SectionDto;
import com.mycompany.myproject.service.svc.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SectionServiceImpl implements SectionService
{
    @Autowired
    private SectionDao sectionDao;

    @Override
    public List<SectionDto> getAllSections() {
        List<SectionDto> sdto = new ArrayList<>();

        for (Section section :
                sectionDao.getAllSections()) {
            sdto.add(new SectionDto(section));
        }
        return sdto;
    }

    @Override
    public void addNewSection(Section section) {
        sectionDao.addNewSection(section);

    }

    @Override
    public void removeSection(Long id) {
        sectionDao.removeSection(id);
    }

//    @Override
//    public SectionDto getSectionById(Long id) {
//        return new SectionDto(sectionDao.getSectionById(id));
//    }

    @Override
    public Section getSectionById(Long id) {
        return sectionDao.getSectionById(id);
    }
}
