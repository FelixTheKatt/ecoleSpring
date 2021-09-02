package com.example.ecole.service;


import com.example.ecole.model.dto.CoursDto;
import com.example.ecole.model.form.CoursForm;

import java.util.List;

public interface CoursService {

    List<CoursDto> getAll();

    void insert(CoursForm form);

    CoursDto insertWithReturnValue(CoursForm form);

    CoursDto getOne(long id);

    Boolean delete(long id);

    CoursDto update(long id, CoursForm form);

}
