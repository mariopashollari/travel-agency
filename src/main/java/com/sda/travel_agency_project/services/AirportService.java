package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.AirportDto;
import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.repositories.AirportRepository;
import com.sda.travel_agency_project.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AirportService {
    private final CityService cityService;
    private final AirportRepository airportRepository;


    public AirportDto create(AirportDto airportDto) {
        Airport airport = AirportDto.toEntity(airportDto);
        airport.setCity(cityService.findById(airportDto.getCityId()));
        return AirportDto.toDto(airportRepository.save(airport));
    }

    public Airport findById(Long id) {
        return airportRepository.findById(id).orElseThrow();
    }

    public AirportDto getById(Long id) {
        return AirportDto.toDto(this.findById(id));
    }

    public AirportDto update(AirportDto airportDto) {
        Airport airport = this.findById(airportDto.getAirportId());
        airport.setName(airportDto.getAirportName());
        return AirportDto.toDto(airportRepository.save(airport));
    }
    public List<AirportDto> findAll() {
        List<Airport> airports = airportRepository.findAll();
        return airports.stream()
                .map(AirportDto::toDto)
                .toList();
    }
}
