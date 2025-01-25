package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.HotelDto;
import com.sda.travel_agency_project.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor

public class HotelController {
    private final HotelService hotelService;

    @PostMapping("/create")
    public HotelDto create(@Valid @RequestBody HotelDto authorDto) {
        return hotelService.create(authorDto);
    }

    @GetMapping("/all")
    public List<HotelDto> findAll() {
        return hotelService.findAll();
    }

    @PutMapping("/update")
    public HotelDto update(@Valid @RequestBody HotelDto authorDto) {
        return hotelService.update(authorDto);
    }

    @GetMapping("/{id}")
    public HotelDto getById(@PathVariable Long id) {
        return hotelService.getById(id);
    }

}
