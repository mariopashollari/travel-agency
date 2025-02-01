package com.sda.travel_agency_project.repositories;

import com.sda.travel_agency_project.entities.PurchasingTour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchasingTourRepository extends JpaRepository<PurchasingTour,Long> {
    List<PurchasingTour> findAllByAgencyUser_userId(Long userId);

}
