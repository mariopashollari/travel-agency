package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Tour;
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


    public static TourIn toEntity(TourDto tourDto) {
        return TourIn.builder()
                .tourId(tourDto.getTourId())
                .tourName(tourDto.getTourName())
                .adultPrice(tourDto.getAdultPrice())
                .childPrice(tourDto.getChildPrice())
                .departureDate(tourDto.getDepartureDate())
                .returnDate(tourDto.getReturnDate())
                .numberOfDays(tourDto.getNumberOfDays())
                .seats(tourDto.getSeats())
                .type(tourDto.getType().name())
                .promoted(tourDto.getPromoted())
                .build();
    }

}
