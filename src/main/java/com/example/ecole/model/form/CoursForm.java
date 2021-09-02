package com.example.ecole.model.form;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CoursForm {

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private String currentFlag;

    private double numbersHours;

}
