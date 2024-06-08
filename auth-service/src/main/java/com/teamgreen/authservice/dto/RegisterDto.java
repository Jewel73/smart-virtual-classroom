package com.teamgreen.authservice.dto;

import com.teamgreen.authservice.request.UserDetailsRequest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {
    private String id;
    private String username;
    private String email;
    
    
    private UserDetailsRequest userDetailsRequest;
}
