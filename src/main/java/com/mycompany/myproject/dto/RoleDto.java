package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    private long roleId;
    private String roleName;

    public RoleDto(Role role) {
        this.roleId = role.getRoleId();
        this.roleName = role.getRoleName();
    }

    public RoleDto() {
    }
}
