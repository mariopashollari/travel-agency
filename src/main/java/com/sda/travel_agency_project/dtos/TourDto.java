package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Tour;
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
    private Long tourId;
    private String tourName;
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

    public static TourDto toDto(Tour tour) {
        return TourDto.builder()
                .tourId(tour.getId())
                .tourName(tour.getName())
                .fromCity(CityDto.toDto(tour.getFrom_city()))
                .toCity(CityDto.toDto(tour.getTo_city()))
                .fromAirport(AirportDto.toDto(tour.getFrom_airport()))
                .toAirport(AirportDto.toDto(tour.getTo_airport()))
                .toHotel(HotelDto.toDto(tour.getTo_hotel()))
                .departureDate(tour.getDeparture_date())
                .returnDate(tour.getReturn_date())
                .adultPrice(tour.getAdultPrice())
                .childPrice(tour.getChildPrice())
                .promoted(tour.getPromoted())
                .seats(tour.getNumberOfSeats())
                .type(tour.getType())
                .build();
    }

}
