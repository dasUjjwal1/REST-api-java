package com.myspringmysql.springsql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDTO {
    @NotBlank(message = "Username is required")
    @NotEmpty(message = "userName:string")
    private String userName;
    @NotBlank(message = "Password is required")
    @NotEmpty(message = "password:string")
    private String password;
}
