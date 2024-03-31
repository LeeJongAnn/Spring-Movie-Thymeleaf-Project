package com.spring.MovieProject.controller;

import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.service.user.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignController {


    private userServiceImpl userService;

    public SignController(userServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/signUp")
    public String signUpUser(User user) {

        userService.signUp(user);
        System.out.println(user);
        return "redirect:/v1/popular";
    }

}
