package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.service.dao.api.CantonDao;
import com.mycompany.myproject.service.dto.CantonDto;
import com.mycompany.myproject.service.svc.CantonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CantonServiceImpl //extends GenericServiceImpl<Canton,CantonDto_OBSOLETE, Long>
        implements CantonService {


    @Autowired
    private CantonDao cantonDao;

    @Override
    public Canton getCantonByName(String name) {
        return cantonDao.getCantonByName(name);
    }

    @Override
    public List<CantonDto> getAllCantons() {
        List<CantonDto> cdto = new ArrayList<>();

        for (Canton canton:
        cantonDao.getAllCantons()) {
            cdto.add(new CantonDto(canton));
        }

        return cdto;
    }


    @Override
    public void addNewCanton(Canton canton) {
        cantonDao.addNewCanton(canton);
    }

    @Override
    public void removeCanton(Long id) {
        cantonDao.removeCanton(id);

    }

    @Override
    public CantonDto getCantonById(Long id) {
        return new CantonDto(cantonDao.getCantonById(id));
    }

    @Override
    public List<String> getAllCantonsNames() {
        List<String> cantonNames  = new ArrayList<>();

        for (Canton canton:
                cantonDao.getAllCantons()) {
            cantonNames.add(canton.getCantonName());
        }
        return cantonNames;
    }

}

