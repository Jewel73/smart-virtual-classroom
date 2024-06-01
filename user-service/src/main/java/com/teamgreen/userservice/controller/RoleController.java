package com.teamgreen.userservice.controller;

import java.util.List;

import javax.management.relation.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamgreen.userservice.dto.request.RoleDto;
import com.teamgreen.userservice.model.ApiResponse;
import com.teamgreen.userservice.model.Role;
import com.teamgreen.userservice.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
    @PostMapping("/create")
	public ResponseEntity<ApiResponse<Role>> create(@RequestBody RoleDto roleDto){
    	
    	try {
    		Role roleResponse = roleService.save(roleDto);
			ApiResponse<Role> response = new ApiResponse<>(roleResponse,"ok",true);
    		return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			ApiResponse<Role> response = new ApiResponse<>(null,"not ok",false);
    		return ResponseEntity.ok(response);
		}
    	
	}

    
    @GetMapping
    public List<Role> getAllRoles(){
    	try {
			List<Role> roleList = roleService.getAllRoles();
	    	return roleList;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
    	
    }
	
	

}
