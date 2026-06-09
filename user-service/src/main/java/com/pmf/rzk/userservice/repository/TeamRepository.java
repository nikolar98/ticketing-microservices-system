package com.pmf.rzk.userservice.repository;

import com.pmf.rzk.userservice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
