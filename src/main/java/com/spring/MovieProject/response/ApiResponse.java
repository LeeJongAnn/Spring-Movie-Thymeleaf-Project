package com.spring.MovieProject.response;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
public class ApiResponse {


    private int page;
    private List<ApiResponseResult> results = new ArrayList<>();
    private int totalPages;
    private int totalResults;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "page=" + page +
                ", results=" + results +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
