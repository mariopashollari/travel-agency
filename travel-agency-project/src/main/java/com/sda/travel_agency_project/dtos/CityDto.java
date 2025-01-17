package com.sda.travel_agency_project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private Integer cityId;
    private String cityName;
    private CountryDto country;
}
