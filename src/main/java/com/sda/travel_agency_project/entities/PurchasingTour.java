package com.sda.travel_agency_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchasingTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tour tour;

    private Double amount;
    private Integer adults;
    private Integer children;
    @ManyToOne
    private AgencyUser agencyUser;

    public Double getAmount() {
        Double adultsPrice = this.adults * this.tour.getAdultPrice();
        Double childrenPrice = this.children * this.tour.getChildPrice();
        return adultsPrice + childrenPrice;
    }
}
