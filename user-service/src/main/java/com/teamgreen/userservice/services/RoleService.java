package com.teamgreen.userservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamgreen.userservice.dto.request.RoleDto;
import com.teamgreen.userservice.model.Role;
import com.teamgreen.userservice.repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoleService {
	
	
	RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Role save(RoleDto roleDto) {
		// Set role from DTO
		Role role = new Role();
		role.setRoleName(roleDto.getRoleName());
		role.setDesc(roleDto.getDesc());
		
		roleRepository.save(role);
		
		return role;
		
	}

	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAllByIsActive(1);
	}
	
	
	public Role findById(Long id) {

		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Role not found with ID: " + id));

		return role;
	}
	
	

}
