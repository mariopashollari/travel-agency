package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.AirportDto;
import com.sda.travel_agency_project.dtos.CountryDto;
import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.entities.Country;
import com.sda.travel_agency_project.repositories.CityRepository;
import com.sda.travel_agency_project.repositories.ContinentRepository;
import com.sda.travel_agency_project.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final ContinentRepository continentRepository;

    private Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    public CountryDto getById(Long id) {
        return CountryDto.toDto(this.findById(id));
    }



}
