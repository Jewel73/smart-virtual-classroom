package com.teamgreen.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.teamgreen.userservice.model.UserDetails;
import com.teamgreen.userservice.request.UserDetailsRequest;

import lombok.Data;

import java.util.List;

import javax.persistence.Embedded;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String id;
    private String username;
    private String email;
    
    @Embedded
    private UserDetails userDetails;
}
