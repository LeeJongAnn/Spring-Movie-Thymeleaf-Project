package com.spring.MovieProject.response;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
@Getter
public class ApiResponse {


    private int page;
    private List<ApiResponseResult> results = new ArrayList<>();
    private int totalPages;
    private int totalResults;
}
