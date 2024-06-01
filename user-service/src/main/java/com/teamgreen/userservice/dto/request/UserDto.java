package com.teamgreen.userservice.dto.request;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
	private Long userId;

	@NotBlank(message = "User name cannot be blank")
	@Size(min = 4, message = "User name must be at least 4 characters")
	private String userName;

	@NotBlank(message = "password cannot be blank")
	@Size(min = 8, message = "Paswword must be at least 8 characters")
	private String password;
	private String firstName;
	private String lastName;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be blank")
	private String email;


//	private List<RoleDto> roleList;
	private RoleDto roleDto;
	private String desc;
}

