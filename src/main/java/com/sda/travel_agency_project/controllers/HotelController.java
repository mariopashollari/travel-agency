package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.HotelDto;
import com.sda.travel_agency_project.entities.Hotel;
import com.sda.travel_agency_project.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")


public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public HotelDto create(@Valid @RequestBody HotelDto hotelDto) {
        return hotelService.create(hotelDto);
    }

    @GetMapping("/public/all")
    public List<HotelDto> findAll() {
        return hotelService.findAll();
    }

    @PutMapping("/update")
    public HotelDto update(@Valid @RequestBody HotelDto hotelDto) {
        return hotelService.update(hotelDto);
    }

    @GetMapping("/public/{id}")
    public HotelDto getById(@PathVariable Long id) {
        return hotelService.getById(id);
    }

    @GetMapping("/public/by_city")
    public List<Hotel> findByCity(@RequestParam Long id){return hotelService.findByCity(id);}

}
