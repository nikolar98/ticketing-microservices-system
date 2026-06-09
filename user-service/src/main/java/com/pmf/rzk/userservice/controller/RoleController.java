package com.pmf.rzk.userservice.controller;

import com.pmf.rzk.userservice.model.Role;
import com.pmf.rzk.userservice.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}