package com.resourcehub.rhbackend.service;

import com.resourcehub.rhbackend.model.User;
import com.resourcehub.rhbackend.model.Role;
import com.resourcehub.rhbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public User createUser(String name, String email, String password, String roleName) {
        Role role = roleService.getRoleByName(roleName);

        User user = new User(name, email, password, role);
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
