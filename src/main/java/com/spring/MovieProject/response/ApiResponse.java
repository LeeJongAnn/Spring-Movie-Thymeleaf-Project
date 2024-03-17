package com.spring.MovieProject.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
public class ApiResponse {


    private int page;
    @JsonProperty("results")
    private List<ApiResponseResult> movieList = new ArrayList<>();
    private int total_pages;
    private int total_results;


}
