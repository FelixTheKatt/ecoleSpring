package com.example.ecole.mappers;

import com.example.ecole.model.dto.RoleDto;
import com.example.ecole.model.entities.Role;
import com.example.ecole.model.form.RoleForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;


@Mapper
public interface RoleMapper {

    @Named("RoleToDto")
    RoleDto toDto(Role entity);

    @Mappings({
            @Mapping(target = "id",ignore = true)
    })
    Role fromFormToEntity(RoleForm roleForm);
}
