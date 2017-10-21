package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.dto.CantonDto;

import java.util.List;


public interface CantonService //extends GenericService<Canton, CantonDto_OBSOLETE, Long>
{
    Canton getCantonByName(String name);
//    List<Canton> getAllCantons();
    List<CantonDto> getAllCantons();
    void addNewCanton(Canton canton);
    void removeCanton(Long id);
    CantonDto getCantonById(Long id);
    List<String>getAllCantonsNames();

}

