package com.teamgreen.userservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.teamgreen.userservice.dto.request.RoleDto;
import com.teamgreen.userservice.dto.request.UserDto;
import com.teamgreen.userservice.model.Role;
import com.teamgreen.userservice.model.User;
import com.teamgreen.userservice.repository.RoleRepository;
import com.teamgreen.userservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	RoleRepository roleRepository;
	@Autowired
	RoleService roleService;
	
	@Autowired
	public UserService() {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.roleService = roleService;
	}
	
	
	public User registerUser(UserDto userDto) {
		
		System.out.println();
		
		User user = User.builder().userName(userDto.getUserName()).firstName(userDto.getFirstName())
				.lastName(userDto.getLastName()).password(userDto.getPassword()).email(userDto.getEmail())
				.desc(userDto.getDesc()).build();
		
		//roleList
//		List<Role> roleList = new ArrayList<>();
		
		Role role = new Role();
		RoleDto roleDto = userDto.getRoleDto();
		
		role = roleService.findById(roleDto.getRoleId());
		
//		for (RoleDto roleDto : roleDtoList) {
//			Role role = roleService.findById(roleDto.getRoleId());
//			roleList.add(role);
//		}
//		user.setRoleList(roleList);
		user.setRole(role);
		 // Save User
		return userRepository.save(user);
	}
	

}
