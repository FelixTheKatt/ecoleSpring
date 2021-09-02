package com.example.ecole.model.form;


import com.example.ecole.model.entities.Cours;
import com.example.ecole.model.entities.Role;
import com.example.ecole.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCoursForm {

    private Long userId;

    private Long coursId;

    private Long roleId;

}
