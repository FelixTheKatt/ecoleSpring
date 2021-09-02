package com.example.ecole.service;

import com.example.ecole.model.dto.RoleDto;
import com.example.ecole.model.dto.UserDto;
import com.example.ecole.model.form.LoginForm;
import com.example.ecole.model.form.RoleForm;
import com.example.ecole.model.form.UserForm;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    void insert(UserForm form);

    UserDto insertWithReturnValue(UserForm form);

    UserDto getOne(long id);

    Boolean delete(long id);

    UserDto update(long id, UserForm form);

    UserDto login(LoginForm form);
}
