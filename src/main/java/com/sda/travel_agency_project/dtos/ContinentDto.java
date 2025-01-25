package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Continent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContinentDto {
    private Long continentId;
    private String continentName;

    public static ContinentDto toDto(Continent continent) {
        return ContinentDto.builder()
                .continentId(continent.getId())
                .continentName(continent.getName())
                .build();
    }
    public static Continent toEntity(ContinentDto continentDto) {
        return Continent.builder()
                .id(continentDto.getContinentId())
                .name(continentDto.getContinentName())
                .build();
    }
}
