package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.HotelDto;
import com.sda.travel_agency_project.entities.Hotel;
import com.sda.travel_agency_project.repositories.CityRepository;
import com.sda.travel_agency_project.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final CityService cityService;

    public HotelDto create(HotelDto hotelDto) {
        Hotel hotel = HotelDto.toEntity(hotelDto);
        hotel.setCity(cityService.findById(hotelDto.getHotelId()));
        return HotelDto.toDto(hotelRepository.save(hotel));
    }
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }

    public HotelDto getById(Long id) {
        return HotelDto.toDto(this.findById(id));
    }

    public HotelDto update(HotelDto hotelDto) {
        Hotel hotel = this.findById(hotelDto.getHotelId());
        if (hotelDto.getCityId() !=  null)
            hotel.setCity(cityService.findById(hotelDto.getHotelId()));
        hotel.setStandard(hotelDto.getNumberOfStars());
        hotel.setName(hotelDto.getHotelName());
        hotel.setDescription(hotelDto.getDescription());
        return HotelDto.toDto(hotelRepository.save(hotel));
    }



}
