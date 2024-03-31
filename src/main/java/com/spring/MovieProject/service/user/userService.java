package com.spring.MovieProject.service.user;


import com.spring.MovieProject.entity.User;

import java.util.List;

public interface userService {


    public void signUp(User user);

    public List<User> listUsers();

}
