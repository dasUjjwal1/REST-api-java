package com.myspringmysql.springsql.service;

import com.myspringmysql.springsql.dto.AuthDTO;
import com.myspringmysql.springsql.dto.AuthResponseDTO;
import com.myspringmysql.springsql.entity.UserModel;
import com.myspringmysql.springsql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    public AuthResponseDTO register(AuthDTO authBody) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authBody.getUserName(), authBody.getPassword())
        );

        String token = tokenService.generateJwt(auth);
        UserModel user = userRepository.findByUserName(authBody.getUserName()).get();
        return AuthResponseDTO.builder()
                .jwtToken(token)
                .user(user)
                .build();
    }
}
