package com.sda.travel_agency_project.entities;

import com.sda.travel_agency_project.static_data.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private City from_city;

    @ManyToOne
    private City to_city;

    @ManyToOne
    private Hotel to_hotel;

    @ManyToOne
    private Airport from_airport;

    @ManyToOne
    private Airport to_airport;

    @Enumerated(EnumType.STRING)
    private Type type;

    private LocalDate departure_date;

    private LocalDate return_date;

    private Integer numberOfDays;

    private Double adultPrice;

    private Double childPrice;

    private Boolean promoted;

    private Integer numberOfSeats;

}
