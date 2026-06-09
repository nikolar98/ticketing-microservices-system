package com.pmf.rzk.userservice.service;

import com.pmf.rzk.userservice.exception.ResourceNotFoundException;
import com.pmf.rzk.userservice.model.User;
import com.pmf.rzk.userservice.repository.RoleRepository;
import com.pmf.rzk.userservice.repository.TeamRepository;
import com.pmf.rzk.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TeamRepository teamRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        if (!roleRepository.existsById(user.getRoleId())) {
            throw new ResourceNotFoundException("Role with id " + user.getRoleId() + " does not exist");
        }

        if (!teamRepository.existsById(user.getTeamId())) {
            throw new ResourceNotFoundException("Team with id " + user.getTeamId() + " does not exist");
        }

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist"));
    }

    public List<User> getUsersByTeamId(Long teamId) {
        if (!teamRepository.existsById(teamId)) {
            throw new ResourceNotFoundException("Team with id " + teamId + " does not exist");
        }

        return userRepository.findByTeamId(teamId);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " does not exist"));

        userRepository.delete(user);
    }
}