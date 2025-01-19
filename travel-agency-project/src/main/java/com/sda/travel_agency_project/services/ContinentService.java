package com.sda.travel_agency_project.services;

import com.sda.travel_agency_project.dtos.ContinentDto;
import com.sda.travel_agency_project.entities.Continent;
import com.sda.travel_agency_project.repositories.ContinentRepository;
import com.sda.travel_agency_project.static_data.ContinentsData;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContinentService {
    private final ContinentRepository continentRepository;

//    public void saveContinents(List<ContinentDto> continentDtos) {
//        for (ContinentDto dto : continentDtos) {
//            if (!continentRepository.existsByName(dto.getContinentName())) {
//                Continent continent = new Continent(dto.getContinentName());
//                continentRepository.save(continent);
//            }
//        }
//    }  //metod per te krijuar te 7 kontinentet automatikisht kur niset prog


    @PostConstruct
    public void init() {
        Arrays.stream(ContinentsData.values()).forEach(continent -> {
            if (!continentRepository.existsByName(continent.getContinentName())) {
                continentRepository.save(Continent.builder()
                        .name(continent.getContinentName())
                        .build());
            }
        });
    }

    public ContinentDto getById(Long id) {
        Continent continent = this.findById(id);
        return ContinentDto.toDto(continent);
    }
    public Continent findById(Long id) {
        return continentRepository.findById(id)
                .orElseThrow();
    }
    public List<ContinentDto> findall() {
        List<Continent> continents = continentRepository.findAll();
        return continents.stream()
                .map(ContinentDto::toDto)
                .toList();
    }


}
