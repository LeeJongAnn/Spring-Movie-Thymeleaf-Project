package com.spring.MovieProject.response;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


public class ApiResponse {


    private int page;
    private List<ApiResponseResult> results = new ArrayList<>();
    private int total_pages;
    private int total_results;

    public List<ApiResponseResult> getListApiResponseResults() {
        return results;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setListApiResponseResults(List<ApiResponseResult> results) {
        this.results = results;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "page=" + page +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
