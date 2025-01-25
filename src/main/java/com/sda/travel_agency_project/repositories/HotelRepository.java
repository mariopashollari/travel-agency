package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
