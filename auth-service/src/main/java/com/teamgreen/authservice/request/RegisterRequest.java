package com.teamgreen.authservice.request;

import com.teamgreen.authservice.enums.Role;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
//    private String role;
    private Role role;
    private UserDetailsRequest userDetailsRequest;
    
}
