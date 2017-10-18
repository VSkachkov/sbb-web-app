//package com.mycompany.myproject.service.dao.impl;
//
//import com.mycompany.myproject.persist.entity.Section;
//import com.mycompany.myproject.service.dao.api.SectionDao;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//public class SectionDaoImp implements SectionDao{
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<Section> getAllSections() {
//        return em.createQuery("FROM Section")
//                .getResultList();
//    }
//
//    @Override
//    public void addNewSection(Section section) {
//        em.persist(section);
//    }
//
//    @Override
//    public void removeSection(Long sectionId) {
//        Section toDeleteSection = this.getSectionById(sectionId);
//        em.remove(toDeleteSection);
//    }
//
//    @Override
//    public Section getSectionById(Long sectionId) {
//        List list = em.createQuery("FROM Section where sectionId=:sectionId")
//                .setParameter("sectionId",sectionId).getResultList();
//        return (list.isEmpty()) ? null : (Section) list.get(0);
//    }
//}
