package com.example.ecole.controller;

import com.example.ecole.model.dto.RoleDto;
import com.example.ecole.model.form.RoleForm;
import com.example.ecole.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Return a list of all the roles
     *
     * @return ResponseEntity<List < RoleDto>> - An list of RoleDto
     */
    @GetMapping()
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(this.roleService.getAll());
    }

    /**
     * Return one role using it's id
     *
     * @param id - The id of the role we want
     * @return ResponseEntity<RoleDto> - The role we want
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<RoleDto> getOne(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.roleService.getOne(id));
    }

    /**
     * Insert one role in the database
     *
     * @param form - The role we want to insert
     * @return ResponseEntity<RoleDto> - The role who was inserted
     */
    @PostMapping()
    public ResponseEntity<RoleDto> post(@Valid @RequestBody RoleForm form) {
        return ResponseEntity.ok(this.roleService.insertWithReturnValue(form));
    }

    /**
     * Delete one role from the database
     *
     * @param id - The id of the role we want to delete
     * @return ResponseEntity<boolean> - Confirmation on the deletion
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.roleService.delete(id));
    }

    /**
     * Updating of a role
     *
     * @param form - the updated form of the role
     * @param id   - The id of the role we want to update
     * @return ResponseEntity<RoleDto> - The updated role
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<RoleDto> update(@PathVariable(name = "id") long id, @Valid @RequestBody RoleForm form) {
        return ResponseEntity.ok(this.roleService.update(id, form));
    }

}
