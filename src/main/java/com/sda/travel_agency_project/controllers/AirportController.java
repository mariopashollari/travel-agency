package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.AirportDto;
import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.services.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

@PostMapping("/create")
public AirportDto create(@Valid @RequestBody AirportDto airportDto) {

    return airportService.create(airportDto);
}
    @PutMapping("/update")
    public AirportDto update(@Valid @RequestBody AirportDto authorDto) {

    return airportService.update(authorDto);
    }

    @GetMapping("/{id}")
    public AirportDto getById(@PathVariable Long id) {

    return airportService.getById(id);
    }
}