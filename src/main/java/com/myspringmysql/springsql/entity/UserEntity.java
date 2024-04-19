package com.myspringmysql.springsql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "tbl_user")
@Entity
public class UserEntity {
    private String email;
    private String password;

}
