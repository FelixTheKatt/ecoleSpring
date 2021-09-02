package com.example.ecole.model.dto;

import com.example.ecole.model.entities.Cours;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InterroDto {

    private Long id;

    private LocalDate date;

    private Cours cours;
}
