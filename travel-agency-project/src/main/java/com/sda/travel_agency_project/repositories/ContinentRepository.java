package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent,Long> {
    boolean existsByName(String name);

}
