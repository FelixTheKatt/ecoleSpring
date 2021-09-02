package com.example.ecole.mappers;

import com.example.ecole.model.dto.UserCoursDto;
import com.example.ecole.model.entities.UserCours;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {RoleMapper.class,UserMapper.class,CoursMapper.class})
public interface UserCoursMapper {

    @Mapping(target = "userDto", source = "user")
    @Mapping(target = "roleDto", source = "role")
    @Mapping(target = "coursDto", source = "cours")
    UserCoursDto toDto(UserCours entity);


}
