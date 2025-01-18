package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {

}
