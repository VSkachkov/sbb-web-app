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
        return em.createQuery("FROM Section")
                .getResultList();
    }

    @Override
    public List<Section> getSectionsByStationId(Long stationId) {
        List <Section> sections = em.createQuery("FROM Section WHERE stationFromId=:stationId OR stationToId=:stationId")
                .setParameter("stationId", stationId)
                .getResultList();
        return sections;
    }

    @Override
    public boolean addNewSectionByParams(Long stationOneId, Long stationTwoId, float length) {
        return false;
    }

    @Override
    public void addNewSection(Section section) {
        em.persist(section);
        em.flush();
    }
}
