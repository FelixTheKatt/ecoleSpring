package com.example.ecole.dbInit;

import com.example.ecole.model.form.CoursForm;
import com.example.ecole.model.form.RoleForm;
import com.example.ecole.model.form.UserCoursForm;
import com.example.ecole.model.form.UserForm;
import com.example.ecole.service.CoursService;
import com.example.ecole.service.RoleService;
import com.example.ecole.service.UserCoursService;
import com.example.ecole.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class DbInitializer implements InitializingBean {

    private final RoleService roleService;
    private final CoursService coursService;
    private final UserService userService;
    private final UserCoursService userCoursService;


    public DbInitializer(RoleService roleService, CoursService coursService, UserService userService, UserCoursService userCoursService) {
        this.roleService = roleService;
        this.coursService = coursService;
        this.userService = userService;
        this.userCoursService = userCoursService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        List<RoleForm> roleForms = Arrays.asList(
                RoleForm.builder()
                        .name("student")
                        .build(),
                RoleForm.builder()
                        .name("prof")
                        .build(),
                RoleForm.builder()
                        .name("admin")
                        .build(),
                RoleForm.builder()
                        .name("super-admin")
                        .build()
        );
        roleForms.forEach(roleService::insert);

        List<CoursForm> coursForms = Arrays.asList(
                CoursForm.builder()
                        .name("initiation base de donnée")
                        .currentFlag("dbinit")
                        .startDate(LocalDate.of(2020,9,9))
                        .endDate(LocalDate.of(2021,4,9))
                        .numbersHours(100)
                        .build(),
                CoursForm.builder()
                        .name("initiation reseaux")
                        .currentFlag("resinit")
                        .startDate(LocalDate.of(2020,9,9))
                        .endDate(LocalDate.of(2021,4,9))
                        .numbersHours(120)
                        .build(),
                CoursForm.builder()
                        .name("anglais")
                        .currentFlag("en")
                        .startDate(LocalDate.of(2020,9,9))
                        .endDate(LocalDate.of(2020,12,9))
                        .numbersHours(80)
                        .build(),
                CoursForm.builder()
                        .name("system d'exploitation")
                        .currentFlag("sys")
                        .startDate(LocalDate.of(2020,9,9))
                        .endDate(LocalDate.of(2021,6,9))
                        .numbersHours(200)
                        .build()

        );
        coursForms.forEach(coursService::insert);

        List<UserForm> userForms = Arrays.asList(
                UserForm.builder()
                        .firstName("felix")
                        .lastName("malchair")
                        .email("felixmalchair@gmail.com")
                        .password("1")
                        .build(),
                UserForm.builder()
                        .firstName("jean")
                        .lastName("jean")
                        .email("jeanjean@gmail.com")
                        .password("1")
                        .build(),
                UserForm.builder()
                        .firstName("marc")
                        .lastName("bari")
                        .email("marcbari@gmail.com")
                        .password("1")
                        .build(),
                UserForm.builder()
                        .firstName("jean-michel")
                        .lastName("vincent")
                        .email("jeanmvincent@gmail.com")
                        .password("1")
                        .build()
        );
        userForms.forEach(userService::insert);

        List<UserCoursForm> userCoursForms = Arrays.asList(
                UserCoursForm.builder()
                        .coursId(1L)
                        .userId(2L)
                        .roleId(1L)
                        .build(),
                UserCoursForm.builder()
                        .coursId(2L)
                        .userId(2L)
                        .roleId(1L)
                        .build(),
                UserCoursForm.builder()
                        .coursId(3L)
                        .userId(2L)
                        .roleId(1L)
                        .build(),
                UserCoursForm.builder()
                        .coursId(1L)
                        .userId(3L)
                        .roleId(1L)
                        .build(),
                UserCoursForm.builder()
                        .coursId(1L)
                        .userId(4L)
                        .roleId(1L)
                        .build(),
                UserCoursForm.builder()
                        .coursId(1L)
                        .userId(1L)
                        .roleId(2L)
                        .build(),
                UserCoursForm.builder()
                        .coursId(2L)
                        .userId(1L)
                        .roleId(2L)
                        .build(),
                UserCoursForm.builder()
                        .coursId(3L)
                        .userId(1L)
                        .roleId(2L)
                        .build()
        );
        userCoursForms.forEach(userCoursService::insert);
    }
}
