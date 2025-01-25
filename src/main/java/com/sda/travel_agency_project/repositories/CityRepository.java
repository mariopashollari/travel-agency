package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findByName(String name);

}
