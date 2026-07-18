package com.fitmyseat.seat.service;

import com.fitmyseat.seat.dto.LoginRequest;
import com.fitmyseat.seat.dto.LoginResponse;
import com.fitmyseat.seat.entity.User;
import com.fitmyseat.seat.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public LoginResponse login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return new LoginResponse(false, "Username and password are required");
        }

        // Optional<User> userOptional = userRepository.findByUsername(username);

        // if (userOptional.isEmpty()) {
        //     return new LoginResponse(false, "Invalid username or password");
        // }

        // User user = userOptional.get();

        // if (!user.getIsActive()) {
        //     return new LoginResponse(false, "User account is inactive");
        // }

        if (!password.equals("1111") && !username.equals("1111")) {
            return new LoginResponse(false, "Invalid username or password");
        }

        return new LoginResponse(true, "Login successful", 1L, username, "test@example.com", "admin");
    }
}
