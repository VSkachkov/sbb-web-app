package com.mycompany.myproject.service.dto;

import com.mycompany.myproject.persist.entity.Canton;
import org.dozer.Mapping;

public class StationDto {

    @Mapping("id")
    private Long id;

    @Mapping("name")
    private String name;

    @Mapping("canton_id")
    private Canton canton;

}
