package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.entities.AgencyUser;
import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.exceptions.AgencyExceptions;
import com.sda.travel_agency_project.repositories.UserRepository;
import com.sda.travel_agency_project.static_data.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AgencyUser create(AgencyUser user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User with this username exists");
        } else {
            user.setActive(true);
            user.setRole(Role.ROLE_USER);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }
    public AgencyUser createAdmin(AgencyUser user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User with this username exists");
        } else {
            user.setActive(true);
            user.setRole(Role.ROLE_ADMIN);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    public ResponseEntity<?> login(String username, String password) {
        try {
            Authentication authentication =
                    authenticationManager.
                            authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return ResponseEntity.ok(authentication.isAuthenticated());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getLocalizedMessage());
        }
    }

    public AgencyUser getUserLoggedIn() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(()-> AgencyExceptions.notFound(User.class.getSimpleName(), username));
    }
}
