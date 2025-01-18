package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Long countryId;
    private String countryName;
    private Long continentId;
    private String continentName;


    public static CountryDto toDto(Country country) {
        return CountryDto.builder()
                .countryId(country.getId())
                .countryName(country.getName())
                .continentId(country.getContinent().getId())
                .continentName(country.getContinent().getName())
                .build();
    }

    public static Country toEntity(CountryDto countryDto) {
        return Country.builder()
                .id(countryDto.getCountryId())
                .name(countryDto.getCountryName())
                .build();

    }


}
