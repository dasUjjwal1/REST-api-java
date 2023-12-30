package com.myspringmysql.springsql.services;

import com.myspringmysql.springsql.config.JwtService;
import com.myspringmysql.springsql.dto.AuthenticationResponse;
import com.myspringmysql.springsql.dto.RegisterUserDTO;
import com.myspringmysql.springsql.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse register(RegisterUserDTO registerUserDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                registerUserDTO.getUserName(), registerUserDTO.getPassword()));
        var user = userRepository.findUserByUserName(registerUserDTO.getUserName()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .jwtToken(jwtToken)
                .user(user).build();
    }
}
