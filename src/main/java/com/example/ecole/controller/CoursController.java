package com.example.ecole.controller;

import com.example.ecole.model.dto.CoursDto;
import com.example.ecole.model.form.CoursForm;
import com.example.ecole.service.CoursService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "cours")
public class CoursController {

    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping()
    public ResponseEntity<List<CoursDto>> getAll() {
        return ResponseEntity.ok(this.coursService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CoursDto> getOne(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.coursService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<CoursDto> post(@Valid @RequestBody CoursForm form) {
        return ResponseEntity.ok(this.coursService.insertWithReturnValue(form));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.coursService.delete(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CoursDto> update(@PathVariable(name = "id") long id, @Valid @RequestBody CoursForm form) {
        return ResponseEntity.ok(this.coursService.update(id, form));
    }
}
