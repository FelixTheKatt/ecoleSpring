package com.example.ecole.controller;

import com.example.ecole.model.dto.CoursDto;
import com.example.ecole.model.dto.UserCoursDto;
import com.example.ecole.model.form.CoursForm;
import com.example.ecole.model.form.UserCoursForm;
import com.example.ecole.service.UserCoursService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "usersCours")
public class UserCoursController {
    private final UserCoursService userCoursService;

    public UserCoursController(UserCoursService userCoursService) {
        this.userCoursService = userCoursService;
    }


    @GetMapping()
    public ResponseEntity<List<UserCoursDto>> getAll() {
        return ResponseEntity.ok(this.userCoursService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserCoursDto> getOne(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.userCoursService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<UserCoursDto> post(@Valid @RequestBody UserCoursForm form) {
        return ResponseEntity.ok(this.userCoursService.insertWithReturnValue(form));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.userCoursService.delete(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserCoursDto> update(@PathVariable(name = "id") long id, @Valid @RequestBody UserCoursForm form) {
        return ResponseEntity.ok(this.userCoursService.update(id, form));
    }
}
