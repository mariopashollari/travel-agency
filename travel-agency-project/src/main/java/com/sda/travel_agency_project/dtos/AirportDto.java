package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Airport;
import com.sda.travel_agency_project.entities.City;
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
    private CityDto city;

    public static Airport toEntity(AirportDto airportDto) {
        return Airport.builder()
                .id(airportDto.getAirportId())
                .name(airportDto.getAirportName())
//                .city(airportDto.getCity())
                .build();
    }

}
