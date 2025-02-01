package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport,Long> {

    @Query("SELECT a FROM Airport a WHERE a.city.id = :cityId")
    List<Airport> findByCity(@Param("cityId") Long cityId);



}
