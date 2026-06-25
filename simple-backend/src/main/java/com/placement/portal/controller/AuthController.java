package com.placement.portal.controller;

import com.placement.portal.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");
        String password = body.get("password");
        Map<String, Object> result = authService.signup(name, email, password);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        Map<String, Object> result = authService.login(email, password);
        return ResponseEntity.ok(result);
    }
}
