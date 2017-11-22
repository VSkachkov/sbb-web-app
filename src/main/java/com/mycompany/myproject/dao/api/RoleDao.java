package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    Role getRoleByRoleId(Long roleId);
    Role getRoleByName(String roleName);
    void addRole(Role role);
}
