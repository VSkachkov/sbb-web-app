package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.service.dto.TrainDto;

import java.util.List;

public interface ManagerService {

    public List<TrainDto> getTrainsForManagers();
}
