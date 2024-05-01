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

    @GetMapping("/v1/popular/{pageNum}")
    public String getPopular(Model model,@PathVariable("pageNum") int pageNum) {

        ApiResponse popularMovieList = movieService.getPopular(pageNum);
        int totalPages = popularMovieList.getTotal_pages();
        System.out.println(totalPages);
        model.addAttribute("popularMovieList", popularMovieList);
        model.addAttribute("address", address);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("totalPages", totalPages);
        return "index";
    }

    @GetMapping("/v1/details/{id}")
    public String getMovieDetails(Model model, @PathVariable(name = "id") Integer id) {

        ApiResponseDetailsMovie movieDetails = movieService.getMovieDetails(id);
        String posterPath = movieDetails.getPoster_path();

        Integer movieDetailsId = movieDetails.getId();
        model.addAttribute("movieDetails", movieDetails);
        model.addAttribute("address", address);
        model.addAttribute("movieDetailsId", movieDetailsId);
        model.addAttribute("posterPath", posterPath);


        return "detail";
    }


}
