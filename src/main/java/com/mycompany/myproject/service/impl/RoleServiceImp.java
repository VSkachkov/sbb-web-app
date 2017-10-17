package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.Role;
import com.mycompany.myproject.service.dao.api.RoleDao;
import com.mycompany.myproject.service.svc.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public void addRole(final String name) {
        final Role role = new Role();
        role.setRoleName(name);
        roleDao.addRole(role);
    }
}
