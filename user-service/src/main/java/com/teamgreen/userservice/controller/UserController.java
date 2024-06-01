package com.teamgreen.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamgreen.userservice.dto.request.UserDto;
import com.teamgreen.userservice.model.ApiResponse;
import com.teamgreen.userservice.model.Role;
import com.teamgreen.userservice.model.User;
import com.teamgreen.userservice.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	public UserController() {
		this.userService = userService;
	}
	
    @PostMapping("/register")
	public ResponseEntity<ApiResponse<User>> registerUser(@RequestBody UserDto userDto) {
    	try {
    		System.out.println("test");
    		User user = userService.registerUser(userDto);
    		System.out.println("test");
    		ApiResponse<User> response = new ApiResponse<>(user,"ok",true);
    		return ResponseEntity.ok(response);
		} catch (Exception e) {
			ApiResponse<User> response = new ApiResponse<>(null,"not ok",false);
    		return ResponseEntity.ok(response);
		}
    	
	}

}
