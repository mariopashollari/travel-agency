package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Airport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirportDto {
    private Long airportId;
    private String airportName;
    private Long cityId;
    private String cityName;

    public static Airport toEntity(AirportDto airportDto) {
        return Airport.builder()
                .id(airportDto.getAirportId())
                .name(airportDto.getAirportName())
                .build();
    }
    public static AirportDto toDto(Airport airport) {
        return AirportDto.builder()
                .airportId(airport.getId())
                .airportName(airport.getName())
                .cityName(airport.getCity().getName())
                .build();
    }

}
