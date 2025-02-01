package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.AgencyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AgencyUser, Long> {
    Optional<AgencyUser> findByUsername(String username);

    Boolean existsByUsername(String username);
}
