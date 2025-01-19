package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.AirportDto;
import com.sda.travel_agency_project.dtos.CityDto;
import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.entities.City;
import com.sda.travel_agency_project.entities.Hotel;
import com.sda.travel_agency_project.repositories.AirportRepository;
import com.sda.travel_agency_project.repositories.CityRepository;
import com.sda.travel_agency_project.repositories.CountryRepository;
import com.sda.travel_agency_project.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final HotelRepository hotelRepository;
    private final AirportRepository airportRepository;


    private City findById(Long id) {
        return cityRepository.findById(id).orElseThrow();
    }

    public CityDto getById(Long id) {
        return CityDto.toDto(this.findById(id));
    }

    public CityDto create(CityDto cityDto) {
        City city = CityDto.toEntity(cityDto);
        city.setCountry(countryRepository.findById(cityDto.getCityId()).orElseThrow());
        return CityDto.toDto(cityRepository.save(city));

    }

    public CityDto update(CityDto cityDto) {
        City city = findById(cityDto.getCityId());
        city.setName(cityDto.getCityName());
        city = cityRepository.save(city);
        return CityDto.toDto(city);
    }

}
