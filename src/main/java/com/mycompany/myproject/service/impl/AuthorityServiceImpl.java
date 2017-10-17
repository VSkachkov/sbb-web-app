package com.mycompany.myproject.service.impl;

import org.springframework.stereotype.Service;
import com.mycompany.myproject.service.svc.AuthorityService;
import com.mycompany.myproject.persist.entity.Authority;
import com.mycompany.myproject.service.dto.AuthorityDto;

@Service
public class AuthorityServiceImpl extends GenericServiceImpl<Authority, AuthorityDto, Long> implements AuthorityService {


}
