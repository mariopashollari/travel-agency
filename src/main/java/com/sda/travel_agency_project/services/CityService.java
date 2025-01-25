package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.CityDto;
import com.sda.travel_agency_project.entities.City;
import com.sda.travel_agency_project.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityService {
    private final CityRepository cityRepository;
    private final CountryService countryService;
    private final HotelService hotelService;

    public CityService(CityRepository cityRepository, CountryService countryService, @Lazy HotelService hotelService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
        this.hotelService = hotelService;
    }


    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow();
    }

    public CityDto getById(Long id) {
        return CityDto.toDto(this.findById(id));
    }

    public CityDto create(CityDto cityDto) {
        City city = CityDto.toEntity(cityDto);
        city.setCountry(countryService.findById(cityDto.getCountryId()));
        return CityDto.toDto(cityRepository.save(city));

    }

    public CityDto update(CityDto cityDto) {
        City city = findById(cityDto.getCityId());
        city.setName(cityDto.getCityName());
        city = cityRepository.save(city);
        return CityDto.toDto(city);
    }
    public List<CityDto> findAll() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(CityDto::toDto)
                .toList();
    }

}
