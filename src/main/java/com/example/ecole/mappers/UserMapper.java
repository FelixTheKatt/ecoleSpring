package com.example.ecole.mappers;

import com.example.ecole.model.dto.CoursDto;
import com.example.ecole.model.dto.UserDto;
import com.example.ecole.model.entities.Cours;
import com.example.ecole.model.entities.User;
import com.example.ecole.model.form.CoursForm;
import com.example.ecole.model.form.UserForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper
public interface UserMapper {

    @Named("UserToDto")
    UserDto toDto(User entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "userCoursList", ignore = true)
    })
    User fromFormToEntity(UserForm userForm);
}
