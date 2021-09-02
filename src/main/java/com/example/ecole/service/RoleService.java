package com.example.ecole.service;

import com.example.ecole.model.dto.CoursDto;
import com.example.ecole.model.dto.RoleDto;
import com.example.ecole.model.form.CoursForm;
import com.example.ecole.model.form.RoleForm;

import java.util.List;

public interface RoleService {

    List<RoleDto> getAll();

    void insert(RoleForm form);

    RoleDto insertWithReturnValue(RoleForm form);

    RoleDto getOne(long id);

    Boolean delete(long id);

    RoleDto update(long id, RoleForm form);
}
