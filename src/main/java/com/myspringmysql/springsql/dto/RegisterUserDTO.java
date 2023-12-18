package com.myspringmysql.springsql.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.myspringmysql.springsql.model.Role;
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
    private String userName;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @JsonProperty("roles")
    private Set<Role> authorities;
}
