package com.example.ecole.service;

import com.example.ecole.model.dto.RoleDto;
import com.example.ecole.model.dto.UserCoursDto;
import com.example.ecole.model.form.RoleForm;
import com.example.ecole.model.form.UserCoursForm;

import java.util.List;

public interface UserCoursService {
    List<UserCoursDto> getAll();

    void insert(UserCoursForm form);

    UserCoursDto insertWithReturnValue(UserCoursForm form);

    UserCoursDto getOne(long id);

    Boolean delete(long id);

    UserCoursDto update(long id, UserCoursForm form);

    List<UserCoursDto> findAllByStudent(Long id);
}
