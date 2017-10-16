package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.service.dto.CantonDto;

import java.util.List;


public interface CantonService //extends GenericService<Canton, CantonDto_OBSOLETE, Long>
{
    Canton getCantonByName(String name);
//    List<Canton> getAllCantons();
    List<CantonDto> getAllCantons();
    void addNewCanton(Canton canton);
    void removeCanton(Long id);
    CantonDto getCantonById(Long id);

}


//import com.mycompany.myproject.persist.entity.Canton;
//import com.mycompany.myproject.service.dto.CantonDto;
//import com.mycompany.myproject.service.dto.CantonDto_OBSOLETE;
//
//import java.util.List;

//public interface CantonService {
//    List<CantonDto> getAllCantons();
//    void addNewCanton(CantonDto canton);
//    void removeCanton(Long id);
//    CantonDto getCantonById(Long id);
//    CantonDto getCantonByName(String name);
//
//}