package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Role;

public interface RoleDao {
    Role getRoleByName(String roleName);
    void addRole(Role role);
}
