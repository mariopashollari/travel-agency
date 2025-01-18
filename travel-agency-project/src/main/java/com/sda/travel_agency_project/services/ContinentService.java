package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.ContinentDto;
import com.sda.travel_agency_project.entities.Continent;
import com.sda.travel_agency_project.repositories.ContinentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContinentService {
    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

//    public void saveContinents(List<ContinentDto> continentDtos) {
//        for (ContinentDto dto : continentDtos) {
//            if (!continentRepository.existsByName(dto.getContinentName())) {
//                Continent continent = new Continent(dto.getContinentName());
//                continentRepository.save(continent);
//            }
//        }
//    }  //metod per te krijuar te 7 kontinentet automatikisht kur niset prog



    public ContinentDto getById(Long id) {
        Continent continent = this.findById(id);
        return ContinentDto.toDto(continent);
    }
    private Continent findById(Long id) {
        return continentRepository.findById(id)
                .orElseThrow();
    }


}
