package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.Tour;
import com.sda.travel_agency_project.static_data.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Long> {
    @Query("SELECT t FROM Tour t WHERE t.to_city.country.continent.id = :continentId")
    List<Tour> findByContinent(@Param("continentId") Long continentId);

    @Query("SELECT t FROM Tour t WHERE t.to_city.country.id = :countryId")
    List<Tour> findByCountry(@Param("countryId") Long countryId);

    @Query("SELECT t FROM Tour t WHERE t.to_city.id = :cityId")
    List<Tour> findByCity(@Param("cityId") Long cityId);

    @Query("SELECT t FROM Tour t WHERE t.to_hotel.id = :hotelId")
    List<Tour> findByHotel(@Param("hotelId") Long hotelId);

    @Query("SELECT t FROM Tour t WHERE t.type = :type")
    List<Tour> findByType(@Param("type") Type type);

    @Query("SELECT t FROM Tour t WHERE t.hotel.standard > :standard")
    List<Tour> findByHotelStarsGreaterThan(@Param("standard") Integer standard);

    @Query("SELECT t FROM Tour t WHERE t.departure_date > :departure_date")
    List<Tour> findByDepartureDateGreaterThan(@Param("departure_date")LocalDate departure_date);

    @Query("SELECT t FROM Tour t WHERE t.promoted = true")
    List<Tour> findPromotedTours();




}

