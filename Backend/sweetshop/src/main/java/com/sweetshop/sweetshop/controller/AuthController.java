package com.sweetshop.sweetshop.controller;

import com.sweetshop.sweetshop.config.JwtUtil;
import com.sweetshop.sweetshop.model.User;
import com.sweetshop.sweetshop.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

public AuthController(UserRepository userRepository,
                      JwtUtil jwtUtil,
                      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
    this.passwordEncoder = passwordEncoder;
}

@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole("USER");
    userRepository.save(user);
    return ResponseEntity.ok("User registered successfully");
}


    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody User user) {

    User dbUser = userRepository.findByUsername(user.getUsername())
            .orElseThrow(() -> new RuntimeException("Invalid credentials"));

    if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    String token = jwtUtil.generateToken(
            dbUser.getUsername(),
            dbUser.getRole()
    );

    return ResponseEntity.ok(Map.of("token", token));
}

   
}
