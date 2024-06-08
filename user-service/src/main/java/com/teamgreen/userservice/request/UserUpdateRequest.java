package com.teamgreen.userservice.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

import com.teamgreen.userservice.model.UserDetails;

@Data
public class UserUpdateRequest {
    @NotBlank(message = "Id is required")
    private String id;
    private String username;
    private String password;
    private UserDetails userDetails;
}
