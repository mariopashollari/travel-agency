package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.CountryDto;
import com.sda.travel_agency_project.entities.Country;
import com.sda.travel_agency_project.services.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor

public class CountryController {
    private final CountryService countryService;

    @PostMapping("/create")
    public CountryDto create(@Valid @RequestBody CountryDto countryDto) {
        return countryService.create(countryDto);
    }

    @GetMapping("/public/all")
    public List<CountryDto> findAll() {
        return countryService.findAll();
    }

    @PutMapping("/update")
    public CountryDto update(@Valid @RequestBody CountryDto countryDto) {
        return countryService.update(countryDto);
    }

    @GetMapping("/public/{id}")
    public CountryDto getById(@PathVariable Long id) {
        return countryService.getById(id);
    }

    @GetMapping("/public/by_continent")
    public List<Country>findByContinent(@RequestParam Long id){return countryService.findByContinent(id);}

}
