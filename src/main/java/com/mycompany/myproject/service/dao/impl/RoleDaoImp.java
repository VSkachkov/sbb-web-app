package com.mycompany.myproject.service.dao.impl;

import com.mycompany.myproject.persist.entity.Role;
import com.mycompany.myproject.service.dao.api.RoleDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

    @Repository
    public class RoleDaoImp implements RoleDao {

        @PersistenceContext
        private EntityManager em;

        @Override
        public Role getRoleByName(String roleName) {

            List list = em.createQuery("FROM Role where roleName=:roleName")
                    .setParameter("roleName",roleName).getResultList();

            return (list.isEmpty()) ? null : (Role) list.get(0);
        }

        @Override
        public void addRole(Role role) {
            em.merge(role);
        }
    }
