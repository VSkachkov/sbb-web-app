package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Role;
import org.springframework.stereotype.Service;



public interface RoleService {

    Role getRoleByName(String name);
    void addRole(String name);
}