package com.spring.MovieProject.service;

import com.spring.MovieProject.response.ApiResponse;
import com.spring.MovieProject.response.details.ApiResponseDetailsMovie;

public interface movieService {

    public ApiResponse getPopular(int pageNum);

    public ApiResponseDetailsMovie getMovieDetails(Integer id);


}
