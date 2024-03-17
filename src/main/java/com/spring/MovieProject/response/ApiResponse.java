package com.spring.MovieProject.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class ApiResponse {


    private int page;
    @JsonProperty("results")
    private List<ApiResponseResult> movieList = new ArrayList<>();
    private int total_pages;
    private int total_results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<ApiResponseResult> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<ApiResponseResult> movieList) {
        this.movieList = movieList;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "page=" + page +
                ", movieList=" + movieList +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
