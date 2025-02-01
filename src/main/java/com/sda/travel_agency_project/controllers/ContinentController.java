package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.CityDto;
import com.sda.travel_agency_project.dtos.ContinentDto;
import com.sda.travel_agency_project.services.ContinentService;
import com.sda.travel_agency_project.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/continent")
public class ContinentController {
    private final ContinentService continentService;


    @GetMapping("/public/all")
    public List<ContinentDto> findAll() {
        return continentService.findAll();
    }


    @GetMapping("/public/{id}")
    public ContinentDto getById(@PathVariable Long id) {
        return continentService.getById(id);
    }

}
