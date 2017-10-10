package com.mycompany.myproject.service.dto;

import org.dozer.Mapping;

public class CantonDto {

    @Mapping("canton_id")
    private Long canton_id;

    @Mapping("canton_name")
    private String name;

    public Long getId() {
        return canton_id;
    }

    public void setId(Long id) {
        this.canton_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
