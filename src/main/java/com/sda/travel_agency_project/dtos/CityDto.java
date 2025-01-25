package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private Long cityId;
    private String cityName;
    private Long countryId;
    private String countryName;

    public static CityDto toDto(City city) {
         return CityDto.builder()
                 .cityId(city.getId())
                 .cityName(city.getName())
                 .countryId(city.getCountry().getId())
                 .countryName(city.getCountry().getName())
                 .build();
    }
    public static City toEntity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getCityId())
                .name(cityDto.getCityName())
                .build();
    }
}
