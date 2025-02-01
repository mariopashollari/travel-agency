package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Tour;
import com.sda.travel_agency_project.static_data.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TourIn {
    private Long tourId;
    private String tourName;
    private Long fromCityId;
    private String fromCityName;
    private Long toCityId;
    private String toCityName;
    private Long fromHotelId;
    private String fromHotelName;
    private Long toHotelId;
    private String toHotelName;
    private Long fromAirportId;
    private String fromAirportName;
    private Long toAirportId;
    private String toAirportName;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private Integer numberOfDays;
    private Double adultPrice;
    private Double childPrice;
    private Boolean promoted;
    private Integer seats;
    private String type;


    public static Tour toEntity(TourIn tourDto) {
        return Tour.builder()
                .id(tourDto.getTourId())
                .name(tourDto.getTourName())
                .adultPrice(tourDto.getAdultPrice())
                .childPrice(tourDto.getChildPrice())
                .departure_date(tourDto.getDepartureDate())
                .return_date(tourDto.getReturnDate())
                .numberOfSeats(tourDto.getSeats())
                .type(Type.valueOf(tourDto.getType()))
                .promoted(tourDto.getPromoted())
                .build();
    }

}
