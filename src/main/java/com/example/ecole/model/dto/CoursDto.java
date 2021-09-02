package com.example.ecole.model.dto;

import lombok.*;

import java.time.LocalDate;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoursDto {

    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private String currentFlag;

    private double numbersHours;
}
