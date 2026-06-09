package com.pmf.rzk.userservice.controller;

import com.pmf.rzk.userservice.model.Team;
import com.pmf.rzk.userservice.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }
}