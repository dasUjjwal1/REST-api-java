package com.myspringmysql.springsql.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserLoginRequest {
    @NotNull(message = "username:string")
    @NotBlank(message = "username required")
    private String username;

    @NotNull(message = "password:string")
    @NotBlank(message = "password required")
    private String password;
}
