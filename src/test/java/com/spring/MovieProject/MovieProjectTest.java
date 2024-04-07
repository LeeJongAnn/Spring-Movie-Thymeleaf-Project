package com.spring.MovieProject;

import com.spring.MovieProject.response.ApiResponse;
import com.spring.MovieProject.response.ApiResponseResult;
import com.spring.MovieProject.response.details.ApiResponseDetailsMovie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
public class MovieProjectTest {


    @Value("${admin}")
    private String apikey;

    static RestTemplate rt = new RestTemplate();
    @Test
    public void apiTest() {
        ResponseEntity<ApiResponse> entity = rt.getForEntity("https://api.themoviedb.org/3/movie/popular?language=ko-KR&page=1&api_key=" + apikey, ApiResponse.class);
        ApiResponse body = entity.getBody();
        List<ApiResponseResult> listApiResponseResults = body.getMovieList();
        System.out.println(listApiResponseResults);
    }

    @Test
    @DisplayName("영화 정보에 관한 디테일한 내용을 얻어옵니다.")
    public void getMovieDetails() {
        ResponseEntity<ApiResponseDetailsMovie> entity = rt.getForEntity("https://api.themoviedb.org/3/movie/643?append_to_response=string&language=ko-KR&api_key=" + apikey, ApiResponseDetailsMovie.class);
        ApiResponseDetailsMovie body = entity.getBody();
        System.out.println(body);
    }

    @Test
    @DisplayName("영화 정보 페이지 파라미터 테스트")
    public void apiPageTest() {

        int pageNum = 3;
        ResponseEntity<ApiResponse> entity = rt.getForEntity("https://api.themoviedb.org/3/movie/popular?language=ko-KR&page="+ pageNum +"&api_key=" + apikey, ApiResponse.class);
        ApiResponse body = entity.getBody();
        List<ApiResponseResult> listApiResponseResults = body.getMovieList();
        System.out.println(listApiResponseResults);
    }
}
