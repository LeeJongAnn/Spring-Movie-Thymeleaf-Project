package com.spring.MovieProject.service.role;

import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.entity.Role;
import com.spring.MovieProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class roleServiceImpl implements roleService {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> roleList() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Integer roleId) {

    }
}
