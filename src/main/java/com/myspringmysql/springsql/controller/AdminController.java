package com.myspringmysql.springsql.controller;

import com.myspringmysql.springsql.dto.RoleDTO;
import com.myspringmysql.springsql.model.Role;
import com.myspringmysql.springsql.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/get-all-role")
    public ResponseEntity<List<Role>> getAllRole() throws HttpClientErrorException.NotFound {
        return ResponseEntity.ok(roleService.getAllRole());
    }

    @PostMapping("/create-role")
    public ResponseEntity<Role> createRole(@RequestBody RoleDTO roleDTO) throws HttpClientErrorException.BadRequest {
        return ResponseEntity.ok(roleService.createRole(roleDTO));
    }
}
