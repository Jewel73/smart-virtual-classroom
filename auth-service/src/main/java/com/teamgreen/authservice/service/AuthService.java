package com.teamgreen.authservice.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.teamgreen.authservice.client.UserServiceClient;
import com.teamgreen.authservice.dto.RegisterDto;
import com.teamgreen.authservice.dto.TokenDto;
import com.teamgreen.authservice.exc.WrongCredentialsException;
import com.teamgreen.authservice.request.LoginRequest;
import com.teamgreen.authservice.request.RegisterRequest;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	@Autowired
    private final AuthenticationManager authenticationManager;
    private final UserServiceClient userServiceClient;
    private final JwtService jwtService;

    public TokenDto login(LoginRequest request) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authenticate.isAuthenticated())
            return TokenDto
                    .builder()
                    .token(jwtService.generateToken(request.getUsername()))
                    .build();
        else throw new WrongCredentialsException("Wrong credentials");
    }

    public RegisterRequest register(RegisterRequest request) {
        return userServiceClient.save(request).getBody();
    }
}
