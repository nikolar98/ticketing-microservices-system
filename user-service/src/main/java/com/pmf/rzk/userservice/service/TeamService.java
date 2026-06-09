package com.pmf.rzk.userservice.service;

import com.pmf.rzk.userservice.model.Team;
import com.pmf.rzk.userservice.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}