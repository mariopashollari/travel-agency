package com.sda.travel_agency_project.entities;

import com.sda.travel_agency_project.static_data.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class AgencyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private Boolean active;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
