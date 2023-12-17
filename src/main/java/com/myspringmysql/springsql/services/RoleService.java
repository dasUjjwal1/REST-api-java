package com.myspringmysql.springsql.services;

import com.myspringmysql.springsql.dto.RoleDTO;
import com.myspringmysql.springsql.model.Role;
import com.myspringmysql.springsql.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }
    public Role createRole(RoleDTO roleDTO){
        Role role = Role.builder().authority(roleDTO.getAuthority()).build();
        return roleRepository.save(role);
    }
}
