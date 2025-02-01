package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Hotel;
import com.sda.travel_agency_project.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    @Query("SELECT h FROM Hotel h WHERE h.city.id = :cityId")
    List<Hotel> findByCity(@Param("cityId") Long cityId);

}
