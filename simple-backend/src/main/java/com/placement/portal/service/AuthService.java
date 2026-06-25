package com.placement.portal.service;

import com.placement.portal.model.User;
import com.placement.portal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Object> signup(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Signup successful");
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("id", user.getId());
        return response;
    }

    public Map<String, Object> login(String email, String password) {
        Optional<User> found = userRepository.findByEmail(email);

        if (found.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = found.get();

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("id", user.getId());
        return response;
    }
}
