package com.example.ecole.service.implementation;

import com.example.ecole.excpetion.NotDeletedException;
import com.example.ecole.excpetion.NotInsertedException;
import com.example.ecole.excpetion.ResourceNotFoundException;
import com.example.ecole.mappers.UserCoursMapper;
import com.example.ecole.model.dto.UserCoursDto;
import com.example.ecole.model.entities.Cours;
import com.example.ecole.model.entities.Role;
import com.example.ecole.model.entities.User;
import com.example.ecole.model.entities.UserCours;
import com.example.ecole.model.form.UserCoursForm;
import com.example.ecole.repositories.CoursRepository;
import com.example.ecole.repositories.RoleRepository;
import com.example.ecole.repositories.UserCoursRepository;
import com.example.ecole.repositories.UserRepositories;
import com.example.ecole.service.UserCoursService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersCoursServiceImplementation implements UserCoursService {

    private final UserCoursRepository userCoursRepository;
    private final UserCoursMapper userCoursMapper;
    private final UserRepositories userRepositories;
    private final CoursRepository coursRepository;
    private final RoleRepository roleRepository;

    public UsersCoursServiceImplementation(UserCoursRepository userCoursRepository, UserCoursMapper userCoursMapper, UserRepositories userRepositories, CoursRepository coursRepository, RoleRepository roleRepository) {
        this.userCoursRepository = userCoursRepository;
        this.userCoursMapper = userCoursMapper;
        this.userRepositories = userRepositories;
        this.coursRepository = coursRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    @Transactional
    public List<UserCoursDto> getAll() {
        return this.userCoursRepository.findAll()
                .stream()
                .map(userCoursMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void insert(UserCoursForm form) {
        User user = userRepositories.getById(form.getUserId());
        Cours cours = coursRepository.getById(form.getCoursId());
        Role role = roleRepository.getById(form.getRoleId());
        UserCours toInsert = new UserCours();
        toInsert.setRole(role);
        toInsert.setCours(cours);
        toInsert.setUser(user);
        userCoursRepository.save(toInsert);
    }

    @Override
    public UserCoursDto insertWithReturnValue(UserCoursForm form) {
        User user = userRepositories.getById(form.getUserId());
        Cours cours = coursRepository.getById(form.getCoursId());
        Role role = roleRepository.getById(form.getRoleId());
        UserCours toInsert = new UserCours();
        toInsert.setRole(role);
        toInsert.setCours(cours);
        toInsert.setUser(user);
        userCoursRepository.save(toInsert);

        return userCoursMapper.toDto(toInsert);
    }

    public UserCours getOneUserCours(long id){
        return this.userCoursRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cours with ID :" + id + " Not Found!"));
    }

    @Override
    public UserCoursDto getOne(long id) {
        return userCoursMapper.toDto(getOneUserCours(id));
    }

    @Override
    public Boolean delete(long id) {
        UserCours toDelete = getOneUserCours(id);
        userCoursRepository.delete(toDelete);

        if (userCoursRepository.existsById(id))
            throw new NotDeletedException("UserCours can't be deleted");
        return true;
    }

    @Override
    public UserCoursDto update(long id, UserCoursForm form) {
        UserCours userCours = getOneUserCours(id);
        userCours.setCours(coursRepository.getById(form.getCoursId()));
        userCours.setUser(userRepositories.getById(form.getUserId()));
        userCours.setRole(roleRepository.getById(form.getRoleId()));
        this.userCoursRepository.save(userCours);
        return this.userCoursMapper.toDto(userCours);
    }
}
