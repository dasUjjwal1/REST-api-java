package com.myspringmysql.springsql.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.myspringmysql.springsql.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {
    @NotEmpty(message = "userName is required")
    @NotBlank(message = "userName:string")
    private String userName;

    @NotEmpty(message = "password is required")
    @NotBlank(message = "password:string")
    private String password;
}
