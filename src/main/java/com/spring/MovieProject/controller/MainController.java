package com.spring.MovieProject.controller;


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

    @GetMapping("/v1/popular")
    public String getPopular(Model model) {

        ApiResponse popularMovieList = movieService.getPopular();
        List<ApiResponseResult> results = popularMovieList.getResults();
        model.addAttribute("results", results);
        return "index";
    }
}
