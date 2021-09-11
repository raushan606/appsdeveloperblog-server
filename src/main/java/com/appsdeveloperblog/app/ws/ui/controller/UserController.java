package com.appsdeveloperblog.app.ws.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;


@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "Get user was invoked";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		logger.info("RequestBODY:>> {}", userDetails);
		
		

		UserRest rest = new UserRest();

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		
		logger.info("CreatedUser:>>  {}", createdUser);
		BeanUtils.copyProperties(createdUser, rest);

		return rest;
	}

	@PutMapping
	public String updateUser() {
		return "Put user was invoked";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete user was invoked";
	}
}
