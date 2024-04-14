package com.spring.MovieProject.service.role;

import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.entity.Role;

import java.util.List;

public interface roleService {


    List<Role> roleList();

    Role saveRole(Role role);

    void deleteRole(Integer roleId);

}
