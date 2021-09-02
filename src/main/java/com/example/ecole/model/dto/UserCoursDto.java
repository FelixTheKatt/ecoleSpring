package com.example.ecole.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCoursDto {

    private Long id;

    private UserDto userDto;

    private CoursDto coursDto;

    private RoleDto roleDto;

}
