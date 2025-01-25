package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.PurchasingTourDto;
import com.sda.travel_agency_project.entities.PurchasingTour;
import com.sda.travel_agency_project.entities.Tour;
import com.sda.travel_agency_project.repositories.PurchasingTourRepository;
import com.sda.travel_agency_project.repositories.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchasingTourService {
    private final PurchasingTourRepository purchasingTourRepository;
    private final TourRepository tourRepository;
    private final UserService userService;

    public PurchasingTourDto create(PurchasingTourDto purchasingTourDto) {
        PurchasingTour purchasingTour = new PurchasingTour();
        Tour tour = tourRepository.findById(purchasingTourDto.getTourId())
                        .orElseThrow();
        purchasingTour.setTour(tour);
        purchasingTour.setAdults(purchasingTourDto.getAdults());
        purchasingTour.setChildren(purchasingTourDto.getChildren());
        purchasingTour.setAmount(purchasingTour.getAmount());
        purchasingTour.setAgencyUser(userService.getUserLoggedIn());
        purchasingTour = purchasingTourRepository.save(purchasingTour);
        return PurchasingTourDto.toDto(purchasingTour);
    }


}
