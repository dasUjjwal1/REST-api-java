package com.myspringmysql.springsql.service;

import com.myspringmysql.springsql.model.UserLoginRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public UserLoginRequest login(UserLoginRequest userLoginRequest){
        return userLoginRequest;
    }
}
