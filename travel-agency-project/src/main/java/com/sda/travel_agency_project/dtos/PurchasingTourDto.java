package com.sda.travel_agency_project.dtos;

import com.sda.travel_agency_project.entities.PurchasingTour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchasingTourDto {
    private Long purchasingTourId;
    private Long tourId;
    private String tourName;
    private Double amount;

    public static PurchasingTourDto toDto(PurchasingTour purchasingTour) {
        return PurchasingTourDto.builder()
                .purchasingTourId(purchasingTour.getId())
                .amount(purchasingTour.getAmount())
                .tourId(purchasingTour.getTour().getId())
                .tourName(purchasingTour.getTour().getName())
                .build();
    }
    public static PurchasingTour toEntity(PurchasingTourDto purchasingTourDto) {
        return PurchasingTour.builder()
                .id(purchasingTourDto.getTourId())
                .amount(purchasingTourDto.getAmount())
                .build();
    }
}
