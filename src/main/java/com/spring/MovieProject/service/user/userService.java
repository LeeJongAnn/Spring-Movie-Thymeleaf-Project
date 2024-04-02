package com.spring.MovieProject.service.user;


import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.UserNotFoundException;

import java.util.List;

public interface userService {


    public void signUp(User user);

    public List<User> listUsers();

    public User getUser(Integer id) throws UserNotFoundException;

    public User updateUser(Integer id);

    public void deleteUser(Integer id) throws UserNotFoundException;

}
