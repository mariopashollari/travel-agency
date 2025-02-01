package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Country;
import com.sda.travel_agency_project.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {
    @Query("SELECT c FROM Country c WHERE c.continent.id = :continentId")
    List<Country> findByContinent(@Param("continentId") Long continentId);


}
