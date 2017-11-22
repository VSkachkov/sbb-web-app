package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dto.RoleDto;
import com.mycompany.myproject.persist.entity.Role;
import com.mycompany.myproject.dao.api.RoleDao;
import com.mycompany.myproject.service.svc.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public List<RoleDto> getAllRoleDtos() {
        List<RoleDto> roleDtos = new ArrayList<>();
        List<Role> roles = roleDao.getAllRoles();
        for (Role role :
                roles) {
            roleDtos.add(new RoleDto(role));
        }
        return roleDtos;
    }

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

    @Override
    public List<Long> getRolesIds() {
        List<Long> roles = new ArrayList<>();
        for (Role role:
                roleDao.getAllRoles()) {
            roles.add(role.getRoleId());
        }
        return roles;
    }
}
