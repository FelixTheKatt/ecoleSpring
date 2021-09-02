package com.example.ecole.service.implementation;

import com.example.ecole.excpetion.NotDeletedException;
import com.example.ecole.excpetion.NotInsertedException;
import com.example.ecole.excpetion.ResourceNotFoundException;
import com.example.ecole.mappers.CoursMapper;
import com.example.ecole.model.dto.CoursDto;
import com.example.ecole.model.entities.Cours;
import com.example.ecole.model.form.CoursForm;
import com.example.ecole.repositories.CoursRepository;
import com.example.ecole.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursServiceImplementation implements CoursService {

    private final CoursRepository coursRepository;
    private final CoursMapper coursMapper;

    public CoursServiceImplementation(CoursRepository coursRepository, CoursMapper coursMapper) {
        this.coursRepository = coursRepository;
        this.coursMapper = coursMapper;
    }


    @Override
    public List<CoursDto> getAll() {
        return this.coursRepository.findAll()
                .stream()
                .map(coursMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(CoursForm form) {
        Cours toInsert = this.coursRepository.save(this.coursMapper.fromFormToEntity(form));
        if (!this.coursRepository.existsById(toInsert.getId()))
            throw new NotInsertedException("cours not inserted");
    }

    @Override
    public CoursDto insertWithReturnValue(CoursForm form) {
        Cours toInsert = this.coursRepository.save(this.coursMapper.fromFormToEntity(form));
        if (!this.coursRepository.existsById(toInsert.getId()))
            throw new NotInsertedException("cours not inserted");

        return coursMapper.toDto(toInsert);
    }

    public Cours getOneCours(long id){
        return this.coursRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cours with ID :" + id + " Not Found!"));
    }

    @Override
    public CoursDto getOne(long id) {
        return coursMapper.toDto(getOneCours(id));
    }

    @Override
    public Boolean delete(long id) {
        Cours toDelete = getOneCours(id);
        coursRepository.delete(toDelete);

        if (coursRepository.existsById(id))
            throw new NotDeletedException("Role can't be deleted");
        return true;
    }

    @Override
    public CoursDto update(long id, CoursForm form) {
        Cours coursUpdate = getOneCours(id);
        coursUpdate.setName(form.getName());
        coursUpdate.setNumbersHours(form.getNumbersHours());
        coursUpdate.setStartDate(form.getStartDate());
        coursUpdate.setStartDate(form.getEndDate());
        coursUpdate.setCurrentFlag(form.getCurrentFlag());
        this.coursRepository.save(coursUpdate);
        return this.coursMapper.toDto(coursUpdate);
    }
}
