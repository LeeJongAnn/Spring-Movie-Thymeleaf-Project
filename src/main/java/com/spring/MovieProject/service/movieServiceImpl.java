package com.spring.MovieProject.service;


import com.spring.MovieProject.response.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class movieServiceImpl implements movieService {


    @Value("${admin}")
    private String apikey;
    private RestTemplate rt;
    @Override
    public ApiResponse getPopular() {
        ResponseEntity<ApiResponse> entity = rt.getForEntity("https://api.themoviedb.org/3/tv/popular?language=en-US&page=1&api_key=" + apikey, ApiResponse.class);
        ApiResponse body = entity.getBody();
        System.out.println(body);
        return body;
    }
}
