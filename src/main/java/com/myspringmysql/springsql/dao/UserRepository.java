package com.myspringmysql.springsql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<String,Integer> {
}
