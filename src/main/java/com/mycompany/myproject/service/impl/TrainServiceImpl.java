package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.persist.entity.Train;
import com.mycompany.myproject.service.dto.TrainDto;
import com.mycompany.myproject.service.impl.GenericServiceImpl;
import com.mycompany.myproject.service.svc.TrainService;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl extends GenericServiceImpl<Train,TrainDto, Long> implements TrainService {

    
}
