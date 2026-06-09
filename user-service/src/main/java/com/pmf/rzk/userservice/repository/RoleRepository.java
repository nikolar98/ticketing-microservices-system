package com.pmf.rzk.userservice.repository;

import com.pmf.rzk.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
