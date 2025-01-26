package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.PurchasingTourDto;
import com.sda.travel_agency_project.entities.PurchasingTour;
import com.sda.travel_agency_project.entities.Tour;
import com.sda.travel_agency_project.repositories.PurchasingTourRepository;
import com.sda.travel_agency_project.repositories.TourRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PurchasingTourService {
    private final PurchasingTourRepository purchasingTourRepository;
    private final TourRepository tourRepository;
    private final UserService userService;

    public PurchasingTourDto create(PurchasingTourDto purchasingTourDto) {
        PurchasingTour purchasingTour = new PurchasingTour();
        Tour tour = tourRepository.findById(purchasingTourDto.getTourId())
                        .orElseThrow();
        Integer seats = purchasingTourDto.getAdults() + purchasingTourDto.getChildren();
        if (tour.getNumberOfSeats() < seats) {
            throw new RuntimeException("Nuk ka vende te lira");
        } else {
            tour.setNumberOfSeats(tour.getNumberOfSeats() - seats);
            tourRepository.save(tour);
        }
        purchasingTour.setTour(tour);
        purchasingTour.setAdults(purchasingTourDto.getAdults());
        purchasingTour.setChildren(purchasingTourDto.getChildren());
        purchasingTour.setAmount(purchasingTour.getAmount());
        purchasingTour.setAgencyUser(userService.getUserLoggedIn());
        purchasingTour = purchasingTourRepository.save(purchasingTour);
        return PurchasingTourDto.toDto(purchasingTour);
    }


    public PurchasingTourDto update(PurchasingTourDto purchasingTourDto) {
        PurchasingTour purchasingTour = findById (purchasingTourDto.getId());
        if (purchasingTour == null) {
            throw new EntityNotFoundException("PurchasingTour not found : " + purchasingTourDto.getId());
        }
        Integer seatsReserved = purchasingTour.getAdults() + purchasingTour.getChildren();
        Integer seatsNew = purchasingTourDto.getAdults() + purchasingTourDto.getChildren();
        Tour tour = purchasingTour.getTour();
        if ((tour.getNumberOfSeats() + seatsReserved) < seatsNew) {
            throw new RuntimeException("Nuk ka vende te lira");
        } else {
            tour.setNumberOfSeats(tour.getNumberOfSeats() + seatsReserved - seatsNew);
            tourRepository.save(tour);
        }
        purchasingTour.setAdults(purchasingTourDto.getAdults());
        purchasingTour.setChildren(purchasingTourDto.getChildren());
        purchasingTour = purchasingTourRepository.save(purchasingTour);
        return PurchasingTourDto.toDto(purchasingTour);
    }

    private PurchasingTour findById(Long id) {
        return purchasingTourRepository.findById(id).orElseThrow();
    }

    public List<PurchasingTourDto> getAll() {
        return purchasingTourRepository.findAll().stream().map(PurchasingTourDto::toDto).toList();
    }

    public List<PurchasingTourDto> findAllByUser(Long userId) {
        return purchasingTourRepository.findAllByAgencyUser_userId(userId).stream().map(PurchasingTourDto::toDto)
                .toList();
    }

}
