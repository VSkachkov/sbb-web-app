package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.service.svc.TimetableService;
import org.springframework.stereotype.Service;

import com.mycompany.myproject.persist.entity.Authority;
import com.mycompany.myproject.service.dto.AuthorityDto;

@Service
public class AuthorityServiceImpl extends GenericServiceImpl<Authority, AuthorityDto, Long> implements TimetableService.AuthorityService {


}
