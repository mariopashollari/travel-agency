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
    private Long id;
    private Long tourId;
    private String tourName;
    private Double amount;
    private Integer adults;
    private Integer children;

    public static PurchasingTourDto toDto(PurchasingTour purchasingTour) {
        return PurchasingTourDto
                .builder()
                .adults(purchasingTour.getAdults())
                .amount(purchasingTour.getAmount())
                .children(purchasingTour.getChildren())
                .tourName(purchasingTour.getTour().getName())
                .build();
    }
}
