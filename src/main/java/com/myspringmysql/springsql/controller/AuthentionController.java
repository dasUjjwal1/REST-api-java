package com.myspringmysql.springsql.controller;

import com.myspringmysql.springsql.dto.RegisterUserDTO;
import com.myspringmysql.springsql.model.UserModel;
import com.myspringmysql.springsql.repository.UserRepository;
import com.myspringmysql.springsql.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthentionController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDTO registerUserDTO) throws HttpClientErrorException.BadRequest {
        Optional<UserModel> user = userRepository.findUserByUserName(registerUserDTO.getUserName());
        if (user.isPresent()) {
            return ResponseEntity.badRequest().body("User already present");
        }
        return ResponseEntity.ok(authenticationService.register(registerUserDTO));
    }

}
