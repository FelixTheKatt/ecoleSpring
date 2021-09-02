package com.example.ecole.service.implementation;

import com.example.ecole.excpetion.ForbiddenException;
import com.example.ecole.excpetion.NotDeletedException;
import com.example.ecole.excpetion.NotInsertedException;
import com.example.ecole.excpetion.ResourceNotFoundException;
import com.example.ecole.mappers.UserMapper;
import com.example.ecole.model.dto.UserDto;
import com.example.ecole.model.entities.Cours;
import com.example.ecole.model.entities.User;
import com.example.ecole.model.form.LoginForm;
import com.example.ecole.model.form.UserForm;
import com.example.ecole.repositories.UserRepositories;
import com.example.ecole.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepositories userRepository;
    private final UserMapper userMapper;

    public UserServiceImplementation(UserRepositories userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserDto> getAll() {
        return this.userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(UserForm form) {
        User toInsert = this.userRepository.save(this.userMapper.fromFormToEntity(form));
        if (!this.userRepository.existsById(toInsert.getId()))
            throw new NotInsertedException("user not inserted");
    }

    @Override
    public UserDto insertWithReturnValue(UserForm form) {
        User toInsert = this.userRepository.save(this.userMapper.fromFormToEntity(form));
        if (!this.userRepository.existsById(toInsert.getId()))
            throw new NotInsertedException("user not inserted");

        return userMapper.toDto(toInsert);
    }

    public User getOneUser(long id){
        return this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cours with ID :" + id + " Not Found!"));
    }

    @Override
    public UserDto getOne(long id) {
        return userMapper.toDto(getOneUser(id));
    }

    @Override
    public Boolean delete(long id) {
        User toDelete = getOneUser(id);
        userRepository.delete(toDelete);

        if (userRepository.existsById(id))
            throw new NotDeletedException("Role can't be deleted");
        return true;
    }

    @Override
    public UserDto update(long id, UserForm form) {
        User userUpdate = getOneUser(id);
        userUpdate.setFirstName(form.getFirstName());
        userUpdate.setLastName(form.getLastName());
        userUpdate.setEmail(form.getEmail());
        userUpdate.setPassword(form.getPassword());
        this.userRepository.save(userUpdate);
        return this.userMapper.toDto(userUpdate);
    }

    @Override
    public UserDto login(LoginForm form) {
        User user = this.userRepository.findByEmailAndPassword(form.getEmail(), form.getPassword());

        if (user == null)
            throw new ForbiddenException("Wrong credentials, please retry");
        return this.userMapper.toDto(user);
    }
}
