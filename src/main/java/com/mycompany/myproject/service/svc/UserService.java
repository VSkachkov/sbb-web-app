package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.dto.UserDto;
import com.mycompany.myproject.service.svc.GenericService;

public interface UserService extends GenericService<User, UserDto, Long> {

}
