package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.CityDto;
import com.sda.travel_agency_project.entities.City;
import com.sda.travel_agency_project.services.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor

public class CityController {
    private final CityService cityService;

    @PostMapping("/create")
    public CityDto create(@Valid @RequestBody CityDto cityDto) {
        return cityService.create(cityDto);
    }

    @GetMapping("/public/all")
    public List<CityDto> findAll() {
        return cityService.findAll();
    }

    @PutMapping("/update")
    public CityDto update(@Valid @RequestBody CityDto cityDto) {
        return cityService.update(cityDto);
    }

    @GetMapping("/public/{id}")
    public CityDto getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    @GetMapping ("/public/by_country")
    public List<City>findByCountry(@RequestParam Long id){return cityService.findByCountry(id);}





}
