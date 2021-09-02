package com.example.ecole.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {

    @NotBlank(message = "Email cannot be empty and null")
    @Email(message = "Email should be valid")
    private String email;


    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=~*])(?=\\S+$).{8,}$",
            message = "Password must contain at least one digit [0-9].\n" +
                    "Password must contain at least one lowercase Latin character [a-z].\n" +
                    "Password must contain at least one uppercase Latin character [A-Z].\n" +
                    "Password must contain at least one special character like @#$%^&+=~* \n" +
                    "Password must contain a length of at least 8 characters \n" +
                    "Password cannot contain whitespaces"
    )
    private String password;
}
