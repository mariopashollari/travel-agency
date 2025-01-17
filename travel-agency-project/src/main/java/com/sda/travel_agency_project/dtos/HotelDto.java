package com.sda.travel_agency_project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Integer hotelId;
    private String hotelName;
    private Integer numberOfStars;
    private String description;
    private CityDto city;

}
