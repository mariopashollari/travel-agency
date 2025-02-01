package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.City;
import com.sda.travel_agency_project.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findByName(String name);

    @Query("SELECT c FROM City c WHERE c.country.id = :countryId")
    List<City> findByCountry(@Param("countryId") Long countryId);

}
