package com.spring.MovieProject;

import com.spring.MovieProject.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class MovieProjectTest {


    @Value("${admin}")
    private String apikey;

    @Test
    public void apiTest() {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<ApiResponse> entity = rt.getForEntity("https://api.themoviedb.org/3/tv/popular?language=en-US&page=1&api_key=" + apikey, ApiResponse.class);
        ApiResponse body = entity.getBody();
        System.out.println(body);
    }
}
