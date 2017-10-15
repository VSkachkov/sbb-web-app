package com.mycompany.myproject.service.dao;

import com.mycompany.myproject.persist.entity.Canton;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public void removeCanton(Long canton_id) {
        Canton toDeleteCanton = this.getCantonById(canton_id);
//        Query query = em.createQuery("DELETE  from Canton  where canton_id=:canton_id");
////        query.executeUpdate();
        em.remove(toDeleteCanton);
//        em.getTransaction().commit();
    }

    @Override
    public Canton getCantonById(Long canton_id) {
        List list = em.createQuery("FROM Canton where canton_id=:canton_id")
                .setParameter("canton_id",canton_id).getResultList();
        return (list.isEmpty()) ? null : (Canton) list.get(0);

    }

    @Override
    public Canton getCantonByName(String canton_name) {

        List list = em.createQuery("FROM Canton where canton_name=:canton_name")
                .setParameter("canton_name", canton_name).getResultList();
        return (list.isEmpty()) ? null : (Canton) list.get(0);
    }
}
