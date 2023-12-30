package com.myspringmysql.springsql.controller;

import com.myspringmysql.springsql.dto.RegisterUserDTO;
import com.myspringmysql.springsql.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDTO registerUserDTO) throws HttpClientErrorException.BadRequest {
        return ResponseEntity.ok(authenticationService.register(registerUserDTO));
    }

}
