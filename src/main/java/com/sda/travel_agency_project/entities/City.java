package com.sda.travel_agency_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Airport> airports;


}
