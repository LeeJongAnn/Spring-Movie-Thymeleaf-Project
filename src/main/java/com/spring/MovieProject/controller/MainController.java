package com.spring.MovieProject.controller;


import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.response.ApiResponse;
import com.spring.MovieProject.response.details.ApiResponseDetailsMovie;
import com.spring.MovieProject.service.movieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/v1/details/{id}")
    public String getMovieDetails(Model model, @PathVariable(name = "id") Integer id) {

        ApiResponseDetailsMovie movieDetails = movieService.getMovieDetails(id);
        model.addAttribute("movieDetails", movieDetails);
        model.addAttribute("address", address);
        model.addAttribute("movie-detail-id", id);
        return "detail";
    }

    @GetMapping("/v1/signUser")
    public String signUp(Model model, User user) {

        model.addAttribute("User", user);
        return "SignUp/signup";
    }
}
