package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.CityDto;
import com.sda.travel_agency_project.dtos.TourDto;
import com.sda.travel_agency_project.dtos.TourIn;
import com.sda.travel_agency_project.entities.City;
import com.sda.travel_agency_project.entities.Tour;
import com.sda.travel_agency_project.repositories.AirportRepository;
import com.sda.travel_agency_project.repositories.CityRepository;
import com.sda.travel_agency_project.repositories.HotelRepository;
import com.sda.travel_agency_project.repositories.TourRepository;
import com.sda.travel_agency_project.static_data.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final CityService cityService;
    private final HotelService hotelService;
    private final AirportService airportService;

    private Tour findById(Long id) {
        return tourRepository.findById(id).orElseThrow();
    }

    public TourDto getById(Long id) {
        return TourDto.toDto(this.findById(id));

    }

    public TourDto create(TourIn tourIn) {
        Tour tour = TourIn.toEntity(tourIn);
        tour.setFrom_airport(airportService.findById(tourIn.getFromAirportId()));
        tour.setTo_airport(airportService.findById(tourIn.getToAirportId()));
        tour.setFrom_city(cityService.findById(tourIn.getFromCityId()));
        tour.setTo_city(cityService.findById(tourIn.getToCityId()));
        tour.setTo_hotel(hotelService.findById(tourIn.getToHotelId()));
        return TourDto.toDto(tourRepository.save(tour));

    }

    public TourDto update(TourDto tourDto) {
        Tour tour = findById(tourDto.getTourId());
        tour.setName(tourDto.getTourName());
        tour.setAdultPrice(tourDto.getAdultPrice());
        tour.setChildPrice(tourDto.getChildPrice());
        tour.setPromoted(tourDto.getPromoted());
        tour.setDeparture_date(tourDto.getDepartureDate());
        tour.setReturn_date(tourDto.getReturnDate());
        tour.setNumberOfDays(tourDto.getNumberOfDays());
        tour.setNumberOfSeats(tourDto.getSeats());
        tour.setType(tourDto.getType());
        tour.setTo_hotel(hotelService.findById(tourDto.getToHotel().getHotelId()));
        tour.setFrom_city(cityService.findById(tourDto.getFromCity().getCityId()));
        tour.setTo_city(cityService.findById(tourDto.getToCity().getCityId()));
        tour.setFrom_airport(airportService.findById(tourDto.getFromAirport().getAirportId()));
        tour.setTo_airport(airportService.findById(tourDto.getToAirport().getAirportId()));
        tour = tourRepository.save(tour);
        return TourDto.toDto(tour);
    }

    public List<TourDto> findall() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .map(TourDto::toDto)
                .toList();
    }

    public List<Tour> getToursByContinentId(Long continentId) {
        return tourRepository.findByContinent(continentId);
    }

    public List<Tour> getToursByCountryId(Long countryId) {
        return tourRepository.findByCountry(countryId);
    }

    public List<Tour> getToursByCityId(Long cityId) {
        return tourRepository.findByCity(cityId);
    }

    public List<Tour> getToursByHotelId(Long hotelId) {
        return tourRepository.findByHotel(hotelId);
    }

    public List<Tour> getToursByType(Type type) {
        return tourRepository.findByType(type);
    }

    public List<Tour> getToursByHotelStarsGreaterThan(Integer standard) {
        return tourRepository.findByHotelStarsGreaterThan(standard);
    }

    public List<Tour> getToursByDepartureDateGreaterThan(LocalDate departure_date) {
        return tourRepository.findByDepartureDateGreaterThan(departure_date);
    }


    public List<Tour> getPromotedTours() {
        return tourRepository.findPromotedTours();


    }
}