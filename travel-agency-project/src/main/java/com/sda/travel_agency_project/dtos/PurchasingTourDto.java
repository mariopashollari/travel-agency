package com.sda.travel_agency_project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchasingTourDto {
    private Integer purchasingTourId;
    private TourDto tour;
    private Double amount;
}
