package com.myspringmysql.springsql.controller;

import com.myspringmysql.springsql.model.UserLoginRequest;
import com.myspringmysql.springsql.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/auth")
public class UserController {
    @Autowired
    private AuthService authService;

    @GetMapping(value = "/welcome")
    public ResponseEntity<?> welcome() {
        return new ResponseEntity<>("Welcome this endpoint is not secure", HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> logIn(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        var res = authService.login(
                UserLoginRequest.builder()
                        .username(userLoginRequest.getUsername())
                        .password(userLoginRequest.getPassword()).build());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
