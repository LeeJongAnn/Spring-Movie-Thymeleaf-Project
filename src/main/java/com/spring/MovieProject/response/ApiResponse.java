package com.spring.MovieProject.response;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class ApiResponse {


    private int page;
    private List<ApiResponseResult> results = new ArrayList<>();
    private int totalPages;
    private int totalResults;

    public List<ApiResponseResult> getListApiResponseResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

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
