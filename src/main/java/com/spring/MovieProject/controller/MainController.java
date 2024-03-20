package com.spring.MovieProject.controller;


import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.response.ApiResponse;
import com.spring.MovieProject.response.ApiResponseResult;
import com.spring.MovieProject.service.movieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private movieServiceImpl movieService;

    private String address = "https://image.tmdb.org/t/p/w500";

    @GetMapping("/v1/popular")
    public String getPopular(Model model) {

        ApiResponse popularMovieList = movieService.getPopular();
        model.addAttribute("popularMovieList", popularMovieList);
        model.addAttribute("address", address);
        return "index";
    }

    @GetMapping("/v1/board")
    public String main(Model model, User user) {

        model.addAttribute("user", user);
        return "SignUp/signup";
    }
}
