package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.RoleDto;
import com.mycompany.myproject.persist.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {

    List<RoleDto> getAllRoleDtos();

    /**
     * returns Role entity by it's name
     *
     * @param name of Role
     * @return Role entity
     */
    Role getRoleByName(String name);

    /**
     * adds new Role for database users
     *
     * @param name Role name
     */
    void addRole(String name);

    List<Long> getRolesIds();

}