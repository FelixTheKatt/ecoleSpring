package com.example.ecole.model.form;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserForm {

    private String firstName;

    private String lastName;

    private String password;

    private String email;
}
