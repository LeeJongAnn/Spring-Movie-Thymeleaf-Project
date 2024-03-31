package com.spring.MovieProject.controller;

import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.service.user.userServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {


    private userServiceImpl userService;

    public UserController(userServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/signUp")
    public String signUpUser(User user) {

        userService.signUp(user);
        System.out.println(user);
        return "redirect:/v1/popular";
    }


    @GetMapping("/v1/userList")
    public String signUpUser(Model model, User user) {

        List<User> usersList = userService.listUsers();

        model.addAttribute("usersList", usersList);
        return "List/userList";
    }


}
