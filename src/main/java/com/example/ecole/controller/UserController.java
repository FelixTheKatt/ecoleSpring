package com.example.ecole.controller;

import com.example.ecole.model.dto.UserDto;
import com.example.ecole.model.form.LoginForm;
import com.example.ecole.model.form.UserForm;
import com.example.ecole.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getOne(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.userService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<UserDto> post(@Valid @RequestBody UserForm form) {
        return ResponseEntity.ok(this.userService.insertWithReturnValue(form));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.userService.delete(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable(name = "id") long id, @Valid @RequestBody UserForm form) {
        return ResponseEntity.ok(this.userService.update(id, form));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginForm form) {
        System.out.println(form);
        return ResponseEntity.ok(this.userService.login(form));
    }
}
