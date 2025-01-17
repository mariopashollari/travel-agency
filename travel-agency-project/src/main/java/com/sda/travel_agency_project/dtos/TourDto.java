package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.static_data.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourDto {
    private Integer tourId;
    private CityDto fromCity;
    private CityDto toCity;
    private HotelDto fromHotel;
    private HotelDto toHotel;
    private AirportDto fromAirport;
    private AirportDto toAirport;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private Integer numberOfDays;
    private Double adultPrice;
    private Double childPrice;
    private Boolean promoted;
    private Integer seats;
    private Type type;
}
