package com.mycompany.myproject.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import com.mycompany.myproject.config.MvcConfig;
import com.mycompany.myproject.config.ServiceConfig;
import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.service.svc.UserService;
import com.mycompany.myproject.config.JPAConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, JPAConfig.class, ServiceConfig.class})
public class UserServiceTest {



    @Autowired
    private UserService userService;


	@Test
	public void testFindOneUser() {
		UserDto userDto = new UserDto(userService.getUserById(1L));
		Assert.assertNotNull(userDto);
		Assert.assertEquals(1, userDto.getUserId().longValue());
	}

	@Test
	public void testGetUserIdByEmail(){

		Long userId = userService.getUserIdByEmail("bublikov@gmail.com");
		UserDto userDto = new UserDto(userService.getUserById(userId));
		Assert.assertNotNull(userDto);
		Assert.assertEquals(10, userDto.getUserId().longValue());
	}

	@Test
	public void testFindAll() {
		List<UserDto> users = userService.getAllUsers();
		Assert.assertFalse(users.isEmpty());
	}

	@Test
	public void testDoesUserExistInDb(){
		UserDto userDto = new UserDto();
		userDto.setFirstName("Vitali");
		userDto.setLastName("Skachkov");
		userDto.setBirthday(userService.getUserById(1L).getBirthday());
		Assert.assertTrue(userService.doesUserExistInDb(userDto));
	}

	@Test
	public void TestGetUserIdByPrivateInfo(){
		UserDto userDto = new UserDto();
		userDto.setFirstName("Vitali");
		userDto.setLastName("Skachkov");
		userDto.setBirthday(userService.getUserById(1L).getBirthday());
		Assert.assertEquals(1, userService.getUserIdByPrivateInfo(userDto).longValue());
	}
}
