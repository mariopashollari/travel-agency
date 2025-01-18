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
    private final CityRepository cityRepository;

    public HotelDto create(HotelDto hotelDto) {
        Hotel hotel = HotelDto.toEntity(hotelDto);
        hotel.setCity(cityRepository.findById(hotelDto.getHotelId()).orElseThrow());
        return HotelDto.toDto(hotelRepository.save(hotel));
    }
    private Hotel findById(Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }

    public HotelDto getById(Long id) {
        return HotelDto.toDto(this.findById(id));
    }

    public HotelDto update(HotelDto hotelDto) {
        Hotel hotel = this.findById(hotelDto.getHotelId());
        hotel = HotelDto.toEntity(hotelDto);
        hotel.setCity(cityRepository.findById(hotelDto.getHotelId()).orElseThrow());
        return HotelDto.toDto(hotelRepository.save(hotel));
    }






}
