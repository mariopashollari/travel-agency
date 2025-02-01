package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.CountryDto;
import com.sda.travel_agency_project.entities.Country;
import com.sda.travel_agency_project.exceptions.AgencyExceptions;
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
    private final ContinentService continentService;

    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(()-> AgencyExceptions.notFound(Country.class.getSimpleName(), id));
    }

    public CountryDto getById(Long id) {
        return CountryDto.toDto(this.findById(id));
    }

    public CountryDto create(CountryDto countryDto) {
        Country country = CountryDto.toEntity(countryDto);
        country.setContinent(continentService.findById(countryDto.getContinentId()));
        return CountryDto.toDto(countryRepository.save(country));
    }

    public CountryDto update(CountryDto countryDto) {
        Country country = findById(countryDto.getCountryId());
        country.setName(countryDto.getCountryName());
        country = countryRepository.save(country);
        return CountryDto.toDto(country);
    }
    public List<CountryDto> findAll() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream()
                .map(CountryDto::toDto)
                .toList();

    }
    public List<Country> findByContinent(Long continentId) {
        return countryRepository.findByContinent(continentId);
    }



}
