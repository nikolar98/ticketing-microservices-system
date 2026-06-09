package com.pmf.rzk.userservice.repository;

import com.pmf.rzk.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByTeamId(Long teamId);
}
