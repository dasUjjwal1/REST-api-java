package com.myspringmysql.springsql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myspringmysql.springsql.entity.UserModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {
    private String jwtToken;
    @JsonProperty("userDetails")
    private UserModel user;
}
