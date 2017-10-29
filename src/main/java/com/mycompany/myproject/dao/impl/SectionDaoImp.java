package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.SectionDao;
import com.mycompany.myproject.persist.entity.Section;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class SectionDaoImp implements SectionDao {


    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Section> getAllSections() {
        return null;
    }

    @Override
    public List<Section> getSectionsByStationId(Long stationId) {
        return null;
    }
}
