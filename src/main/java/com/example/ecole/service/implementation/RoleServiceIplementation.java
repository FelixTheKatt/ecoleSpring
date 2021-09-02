package com.example.ecole.service.implementation;

import com.example.ecole.excpetion.NotDeletedException;
import com.example.ecole.excpetion.NotInsertedException;
import com.example.ecole.excpetion.ResourceNotFoundException;
import com.example.ecole.mappers.RoleMapper;
import com.example.ecole.model.dto.RoleDto;
import com.example.ecole.model.entities.Role;
import com.example.ecole.model.form.RoleForm;
import com.example.ecole.repositories.RoleRepository;
import com.example.ecole.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceIplementation implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceIplementation(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDto> getAll() {
        return this.roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insert(RoleForm form) {
        Role toInsert = this.roleRepository.save(this.roleMapper.fromFormToEntity(form));
        if (!this.roleRepository.existsById(toInsert.getId()))
            throw new NotInsertedException("Role not inserted");
    }

    @Override
    public RoleDto insertWithReturnValue(RoleForm form) {
        Role newRole = this.roleRepository.save(this.roleMapper.fromFormToEntity(form));
        if (!roleRepository.existsById(newRole.getId()))
            throw new NotInsertedException("Role can't be inserted");

        return roleMapper.toDto(newRole);
    }

    public Role getOneRole(long id) {
        return this.roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role with ID :" + id + " Not Found!"));
    }

    @Override
    public RoleDto getOne(long id) {
        return this.roleMapper.toDto(getOneRole(id));
    }

    @Override
    public Boolean delete(long id) {
        Role toDelete = getOneRole(id);
        roleRepository.delete(toDelete);

        if (roleRepository.existsById(id))
            throw new NotDeletedException("Role can't be deleted");
        return true;
    }

    @Override
    public RoleDto update(long id, RoleForm form) {
        Role roleUpdate = getOneRole(id);
        roleUpdate.setName(form.getName());
        this.roleRepository.save(roleUpdate);
        return this.roleMapper.toDto(roleUpdate);

    }
}
