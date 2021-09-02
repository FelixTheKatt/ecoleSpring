package com.example.ecole.mappers;

import com.example.ecole.model.dto.CoursDto;
import com.example.ecole.model.entities.Cours;
import com.example.ecole.model.form.CoursForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;


@Mapper
public interface CoursMapper {

    @Named("CoursToDto")
    CoursDto toDto(Cours entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "interros", ignore = true),
            @Mapping(target = "userCours", ignore = true)
    })
    Cours fromFormToEntity(CoursForm roleForm);
}
