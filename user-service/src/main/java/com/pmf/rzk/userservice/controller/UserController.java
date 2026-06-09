package com.pmf.rzk.userservice.controller;

import com.pmf.rzk.userservice.model.User;
import com.pmf.rzk.userservice.service.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable @Min(1) Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/team/{teamId}")
    public List<User> getUsersByTeamId(@PathVariable @Min(1) Long teamId) {
        return userService.getUsersByTeamId(teamId);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable @Min(1) Long id) {
        userService.deleteUser(id);
    }

}