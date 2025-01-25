package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.CityDto;
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
    public CityDto create(@Valid @RequestBody CityDto authorDto) {
        return cityService.create(authorDto);
    }

    @GetMapping("/all")
    public List<CityDto> findAll() {
        return cityService.findAll();
    }

    @PutMapping("/update")
    public CityDto update(@Valid @RequestBody CityDto authorDto) {
        return cityService.update(authorDto);
    }

    @GetMapping("/{id}")
    public CityDto getById(@PathVariable Long id) {
        return cityService.getById(id);
    }


}
