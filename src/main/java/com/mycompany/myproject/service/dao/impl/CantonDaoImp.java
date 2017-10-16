package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.service.dao.api.CantonDao;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CantonDaoImp implements CantonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Canton> getAllCantons() {
        return em.createQuery("FROM Canton")
                .getResultList();
    }


    @Override
    public void addNewCanton(Canton canton) {
        em.persist(canton);

    }

    @Override
    public void removeCanton(Long cantonId) {
        Canton toDeleteCanton = this.getCantonById(cantonId);
//        Query query = em.createQuery("DELETE  from Canton  where canton_id=:canton_id");
////        query.executeUpdate();
        em.remove(toDeleteCanton);
//        em.getTransaction().commit();
    }

    @Override
    public Canton getCantonById(Long cantonId) {
        List list = em.createQuery("FROM Canton where cantonId=:cantonId")
                .setParameter("cantonId",cantonId).getResultList();
        return (list.isEmpty()) ? null : (Canton) list.get(0);

    }

    @Override
    public Canton getCantonByName(String cantonName) {

        List list = em.createQuery("FROM Canton where cantonName=:cantonName")
                .setParameter("cantonName", cantonName).getResultList();
        return (list.isEmpty()) ? null : (Canton) list.get(0);
    }
}
