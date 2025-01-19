package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.AirportDto;
import com.sda.travel_agency_project.dtos.CityDto;
import com.sda.travel_agency_project.dtos.CountryDto;
import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.entities.City;
import com.sda.travel_agency_project.entities.Country;
import com.sda.travel_agency_project.repositories.CityRepository;
import com.sda.travel_agency_project.repositories.ContinentRepository;
import com.sda.travel_agency_project.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final CityService cityService;
    private final ContinentService continentService;

    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    public CountryDto getById(Long id) {
        return CountryDto.toDto(this.findById(id));
    }

    public CountryDto create(CountryDto countryDto) {
        Country country = CountryDto.toEntity(countryDto);
        country.setContinent(continentService.findById(countryDto.getCountryId()));
        return CountryDto.toDto(countryRepository.save(country));
    }

    public CountryDto update(CountryDto countryDto) {
        Country country = findById(countryDto.getCountryId());
        country.setName(countryDto.getCountryName());
        country = countryRepository.save(country);
        return CountryDto.toDto(country);
    }
    public List<CountryDto> findall() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream()
                .map(CountryDto::toDto)
                .toList();

    }

}
