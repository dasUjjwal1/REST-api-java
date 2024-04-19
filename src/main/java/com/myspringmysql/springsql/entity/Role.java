package com.myspringmysql.springsql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "tbl_roles")
public class Role {
    private Integer roleId;
    private String roleName;

}
