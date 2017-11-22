package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.dao.api.SectionDao;
import com.mycompany.myproject.dao.api.StationDao;
import com.mycompany.myproject.persist.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class SectionDaoImp implements SectionDao {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    StationDao stationDao;


    @Override
    public List<Section> getAllSections() {
        return em.createQuery("FROM Section")
                .getResultList();
    }

    @Override
    public List<Section> getSectionsByStationId(Long stationId) {
        List <Section> sections = em.createQuery("FROM Section WHERE stationFromId=:stationId OR stationToId=:stationId")
                .setParameter("stationId", stationDao.getStationById(stationId))
                .getResultList();
        return sections;
    }

    @Override
    public List<Section> getSectionsByStationFromId(Long stationId) {
        List <Section> sections = em.createQuery("FROM Section WHERE stationFromId=:stationId")
                .setParameter("stationId", stationDao.getStationById(stationId))
                .getResultList();
        return sections;
    }

    @Override
    public List<Section> getSectionsByStationToId(Long stationId) {
        List <Section> sections = em.createQuery("FROM Section WHERE stationToId=:stationId")
                .setParameter("stationId", stationDao.getStationById(stationId))
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

    @Override
    public Section getSectionById( Long sectionId) {
        List list = em.createQuery("FROM Section where sectionId=:sectionId")
                .setParameter("sectionId",sectionId).getResultList();
        return (list.isEmpty()) ? null : (Section) list.get(0);
    }

    @Override
    public void deleteSection(Long sectionId) {
        em.remove((Section) em.find(Section.class, sectionId));
    }

    @Override
    public void updateLength(Long sectionId, float length) {
        Query query = em.createQuery("UPDATE Section set length=:length  where sectionId=:sectionId")
                .setParameter("sectionId",sectionId)
                .setParameter("length", length);
        query.executeUpdate();
    }
}
