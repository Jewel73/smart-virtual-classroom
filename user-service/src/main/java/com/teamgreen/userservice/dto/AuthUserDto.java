package com.teamgreen.userservice.dto;

import com.teamgreen.userservice.enums.Role;

import lombok.Data;

@Data
public class AuthUserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
}