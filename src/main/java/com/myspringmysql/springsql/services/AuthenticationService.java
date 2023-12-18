package com.myspringmysql.springsql.services;

import com.myspringmysql.springsql.config.JwtService;
import com.myspringmysql.springsql.dto.AuthenticationResponse;
import com.myspringmysql.springsql.dto.RegisterUserDTO;
import com.myspringmysql.springsql.model.UserModel;
import com.myspringmysql.springsql.repository.RoleRepository;
import com.myspringmysql.springsql.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse register(RegisterUserDTO registerUserDTO) {
        var user = UserModel.builder()
                .firstname(registerUserDTO.getFirstname())
                .lastname(registerUserDTO.getLastname())
                .email(registerUserDTO.getEmail())
                .userName(registerUserDTO.getUserName())
                .authorities(registerUserDTO.getAuthorities())
                .password(passwordEncoder.encode(registerUserDTO.getPassword()))
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(savedUser);
        return AuthenticationResponse.builder()
                .jwtToken(jwtToken)
                .user(savedUser).build();
    }
}
