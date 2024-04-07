package com.spring.MovieProject.service;


import com.spring.MovieProject.response.ApiResponse;
import com.spring.MovieProject.response.details.ApiResponseDetailsMovie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class movieServiceImpl implements movieService {


    @Value("${admin}")
    private String apikey;
    private RestTemplate rt = new RestTemplate();

    @Override
    public ApiResponse getPopular(int page) {
        ResponseEntity<ApiResponse> entity = rt.getForEntity("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=ko-KR&page=" + page + "&sort_by=popularity.desc&api_key=" + apikey, ApiResponse.class);
        ApiResponse body = entity.getBody();
        return body;
    }

    @Override
    public ApiResponseDetailsMovie getMovieDetails(Integer id) {
        ResponseEntity<ApiResponseDetailsMovie> detailsMovie = rt.getForEntity("https://api.themoviedb.org/3/movie/" + id + "?append_to_response=string&language=ko-KR&api_key=" + apikey, ApiResponseDetailsMovie.class);
        ApiResponseDetailsMovie body = detailsMovie.getBody();
        return body;
    }
}
