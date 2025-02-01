package com.sda.travel_agency_project.controllers;

import com.sda.travel_agency_project.dtos.ContinentDto;
import com.sda.travel_agency_project.dtos.TourDto;
import com.sda.travel_agency_project.dtos.TourIn;
import com.sda.travel_agency_project.entities.Tour;
import com.sda.travel_agency_project.services.TourService;
import com.sda.travel_agency_project.static_data.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tour")
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;

    @PostMapping("/create")
    public TourDto create(@RequestBody TourIn tourIn) {return tourService.create(tourIn);}

    @GetMapping("/public/{id}")
    public TourDto getById(@PathVariable Long id) {return tourService.getById(id);}

    @PutMapping("/update")
    public TourDto update(@RequestBody TourIn tourIn) {return tourService.update(tourIn);}

    @GetMapping("/public/all")
    public List<TourDto> findAll() {return tourService.findAll();}

    @GetMapping("/public/by_continent")
    public List<Tour> findByContinent(@RequestParam Long id) {return tourService.getToursByContinentId(id);}

    @GetMapping("/public/by_country")
    public List<Tour> findByCountry(@RequestParam Long id) {return tourService.getToursByCountryId(id);}

    @GetMapping("/public/by_city")
    public List<Tour> findByCity(@RequestParam Long id) {return tourService.getToursByCityId(id);}

    @GetMapping("/public/by_hotel")
    public List<Tour> findByHotel(@RequestParam Long id) {return tourService.getToursByHotelId(id);}

    @GetMapping("/public/by_type")
    public List<Tour> findByType(@RequestParam String type) {return tourService.getToursByType(type);}

    @GetMapping("/public/by_promoted")
    public List<Tour> findAllPromoted() {return tourService.getPromotedTours();}

    @GetMapping("/public/between_departure_date")
    public List<Tour> findAllDepartureDateBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {return tourService.findAllDepartureDateBetween(startDate, endDate);}

    @GetMapping("/public/by_hotel_standard_greater")
    public List<Tour> findByHotelStarsGreaterThan(@RequestParam Integer standard) {return tourService.getToursByHotelStarsGreaterThan(standard);}

    @GetMapping("/public/between_return_date")
    public List<Tour> findAllReturnDateBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {return tourService.findAllReturnDateBetween(startDate, endDate);}

    @GetMapping("/public/by_departure_date_greater")
    public List<Tour> findByDepartureDateGreaterThan(@RequestParam LocalDate departure_date) {return tourService.getToursByDepartureDateGreaterThan(departure_date);}

    @GetMapping("/deactivate/{id}")
    public void deactivateTour(@PathVariable Long id) {
         tourService.deactivateTour(id);

    }
}
