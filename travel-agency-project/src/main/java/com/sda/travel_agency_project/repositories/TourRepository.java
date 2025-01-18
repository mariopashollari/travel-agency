package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour,Long> {

}
