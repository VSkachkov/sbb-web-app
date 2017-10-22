package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.Canton;

import java.util.List;

public interface CantonDao {
    List<Canton> getAllCantons();
    void addNewCanton(Canton canton);
    void removeCanton(Long id);
    Canton getCantonById(Long id);
    Canton getCantonByName(String name);
}