package com.sda.travel_agency_project.controllers;


import com.sda.travel_agency_project.dtos.PurchasingTourDto;
import com.sda.travel_agency_project.services.PurchasingTourService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/purchasing")
public class PurchasingController {

    @Autowired
    private PurchasingTourService purchasingTourService;

    @GetMapping("/all")
    public List<PurchasingTourDto> getAll() {
        return purchasingTourService.getAll();
    }

    @GetMapping("/{id}")
    public PurchasingTourDto geById(@PathVariable Long id) {
        return purchasingTourService.getById(id);
    }

    @PostMapping("/create")
    public PurchasingTourDto create(@Valid @RequestBody PurchasingTourDto purchasingTourDto) {
        return purchasingTourService.create(purchasingTourDto);
    }

    @PutMapping("/update")
    public PurchasingTourDto update(@Valid @RequestBody PurchasingTourDto purchasingTourDto) {
        return purchasingTourService.update(purchasingTourDto);
    }
}
