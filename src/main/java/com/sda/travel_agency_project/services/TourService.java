package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.TourDto;
import com.sda.travel_agency_project.dtos.TourIn;
import com.sda.travel_agency_project.entities.Tour;
import com.sda.travel_agency_project.exceptions.AgencyExceptions;
import com.sda.travel_agency_project.repositories.TourRepository;
import com.sda.travel_agency_project.static_data.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        return tourRepository.findById(id).orElseThrow(()-> AgencyExceptions.notFound(Tour.class.getSimpleName(), id));
    }

    public TourDto getById(Long id) {
        return TourDto.toDto(this.findById(id));

    }

    public TourDto create(TourIn tourIn) {
        Tour tour = TourIn.toEntity(tourIn);
        Long numberOfDays = calculateDays(tourIn);
        tour.setNumberOfDays(numberOfDays);
        tour.setFrom_airport(airportService.findById(tourIn.getFromAirportId()));
        tour.setTo_airport(airportService.findById(tourIn.getToAirportId()));
        tour.setFrom_city(cityService.findById(tourIn.getFromCityId()));
        tour.setTo_city(cityService.findById(tourIn.getToCityId()));
        tour.setTo_hotel(hotelService.findById(tourIn.getToHotelId()));
        tour.setActivated(true);
        return TourDto.toDto(tourRepository.save(tour));

    }

    private Long calculateDays(TourIn tourIn) {
        return ChronoUnit.DAYS.between(tourIn.getDepartureDate(), tourIn.getReturnDate());
    }

    public TourDto update(TourIn tourIn) {
        Tour tour = findById(tourIn.getTourId());
        tour.setName(tourIn.getTourName());
        tour.setAdultPrice(tourIn.getAdultPrice());
        tour.setChildPrice(tourIn.getChildPrice());
        tour.setPromoted(tourIn.getPromoted());
        tour.setDeparture_date(tourIn.getDepartureDate());
        tour.setReturn_date(tourIn.getReturnDate());
        tour.setNumberOfDays(calculateDays(tourIn));
        tour.setNumberOfSeats(tourIn.getSeats());
        tour.setType(Type.valueOf(tourIn.getType()));
        tour.setTo_hotel(hotelService.findById(tourIn.getToHotelId()));
        tour.setFrom_city(cityService.findById(tourIn.getFromCityId()));
        tour.setTo_city(cityService.findById(tourIn.getToCityId()));
        tour.setFrom_airport(airportService.findById(tourIn.getFromAirportId()));
        tour.setTo_airport(airportService.findById(tourIn.getToAirportId()));
        tour = tourRepository.save(tour);
        return TourDto.toDto(tour);
    }

    public List<TourDto> findAll() {
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

//    public List<Tour> getToursByType(Type type) {
//        return tourRepository.findByType(type);
//    }

    public List<Tour> getToursByHotelStarsGreaterThan(Integer standard) {
        return tourRepository.findByHotelStarsGreaterThan(standard);
    }

    public List<Tour> getToursByDepartureDateGreaterThan(LocalDate departure_date) {
        return tourRepository.findByDepartureDateGreaterThan(departure_date);
    }


    public List<Tour> getPromotedTours() {
        return tourRepository.findPromotedTours();
    }

    public List<Tour> findAllDepartureDateBetween(LocalDate startDate, LocalDate endDate) {
        return tourRepository.findAllDepartureDateBetween(startDate, endDate);
    }

    public List<Tour> findAllReturnDateBetween(LocalDate startDate, LocalDate endDate) {
        return tourRepository.findAllReturnDateBetween(startDate, endDate);

    }

    public void deactivateTour(Long id) {
        Tour tour = this.findById(id);
        tour.setActivated(false);
        tourRepository.save(tour);

    }

    public List<Tour> getToursByType(String type) {
        try {
            Type enumType = Type.valueOf(type.toUpperCase());
            return tourRepository.findByType(enumType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid tour type: " + type);
        }
    }
}