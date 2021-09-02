package com.example.ecole.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInterro {
    private Long id;

    private Boolean present;

    private Integer points;

}
