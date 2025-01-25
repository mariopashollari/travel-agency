package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {

}
