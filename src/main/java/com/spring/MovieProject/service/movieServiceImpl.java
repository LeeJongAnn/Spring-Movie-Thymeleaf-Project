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
    private RestTemplate rt = new RestTemplate();

    @Override
    public String getPopular() {
        ResponseEntity<String> entity = rt.getForEntity("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1&api_key=" + apikey, String.class);
        String body = entity.getBody();
        System.out.println(body);
        return body;
    }
}
