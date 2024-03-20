package com.spring.MovieProject.controller;

import com.spring.MovieProject.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignController {


    @PostMapping("/v1/signUp")
    public String signUpUser(User user) {
        System.out.println(user);
        return "redirect:/v1/popular";
    }

}
