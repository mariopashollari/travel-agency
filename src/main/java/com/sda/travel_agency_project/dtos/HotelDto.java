package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Long hotelId;
    private String hotelName;
    private Integer numberOfStars;
    private String description;
    private Long cityId;
    private String cityName;

    public static HotelDto toDto(Hotel hotel) {
        return HotelDto.builder()
                .hotelId(hotel.getId())
                .hotelName(hotel.getName())
                .numberOfStars(hotel.getStandard())
                .description(hotel.getDescription())
                .cityId(hotel.getCity().getId())
                .cityName(hotel.getCity().getName())
                .build();
    }

    public static Hotel toEntity(HotelDto hotelDto) {
        return Hotel.builder()
                .id(hotelDto.getHotelId())
                .name(hotelDto.getHotelName())
                .standard(hotelDto.getNumberOfStars())
                .description(hotelDto.getDescription())
                .build();
    }

}
