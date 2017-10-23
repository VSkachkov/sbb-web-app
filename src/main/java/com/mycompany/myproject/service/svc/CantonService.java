package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.dto.CantonDto;

import java.util.List;


public interface CantonService //extends GenericService<Canton, CantonDto_OBSOLETE, Long>
{
    /**
     * Gets Canton entity by it's unique name
     * @param name of Canton
     * @return Canton
     */
    Canton getCantonByName(String name);

    /**
     * gets nothing
     * @return List of Canton as DTO objects
     */
    List<CantonDto> getAllCantons();

    /**
     *Adds Canton entity to database
     * @param canton of Canton
     */
    void addNewCanton(Canton canton);

    /**
     * finds Entity in database and removes it
     * @param id Canton id
     */
    void removeCanton(Long id);

    /**
     * finds Canton entity in database and returns it's DTO representation
     * @param id Canton Id
     * @return Canton DTO
     */
    CantonDto getCantonById(Long id);

    /**
     * extracts names of all cantons from database
     * @return names of all cantons
     */
    List<String>getAllCantonsNames();

}

