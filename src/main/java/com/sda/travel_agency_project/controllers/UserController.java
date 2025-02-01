package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.entities.AgencyUser;
import com.sda.travel_agency_project.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/public/create")
    public AgencyUser create(@RequestBody AgencyUser user) {
        return userService.create(user);
    }

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }
    @PostMapping("/create_admin")
    public AgencyUser createAdmin(@RequestBody AgencyUser user) {
        return userService.createAdmin(user);
    }
}
