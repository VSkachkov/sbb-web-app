package com.mycompany.myproject.dao.impl;

import com.mycompany.myproject.persist.entity.Role;
import com.mycompany.myproject.dao.api.RoleDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

    @Repository
    public class RoleDaoImp implements RoleDao {

        @PersistenceContext
        private EntityManager em;

        @Override
        public List<Role> getAllRoles() {
            List list = em.createQuery("FROM Role")
                    .getResultList();
            return list;
        }

        @Override
        public Role getRoleByRoleId(Long roleId) {
            List list = em.createQuery("FROM Role where roleId=:roleId")
                    .setParameter("roleId",roleId).getResultList();
            return (list.isEmpty()) ? null : (Role) list.get(0);
        }

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
