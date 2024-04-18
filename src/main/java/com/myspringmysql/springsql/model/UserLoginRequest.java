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
    @NotNull()
    @NotBlank()
    private String username;

    @NotNull()
    @NotBlank()
    private String password;
}
