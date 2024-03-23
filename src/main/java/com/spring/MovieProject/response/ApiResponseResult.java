package com.spring.MovieProject.response;


import lombok.Data;
import lombok.Getter;

import java.util.Date;

public class ApiResponseResult {

    private Integer id;
    private String adult;
    private String title;
    private String original_name;
    private String overview;
    private String popularity;
    private String poster_path;
    private String release_date;
    private float vote_average;
    private float vote_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getVote_count() {
        return vote_count;
    }

    public void setVote_count(float vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "ApiResponseResult{" +
                "adult='" + adult + '\'' +
                ", title='" + title + '\'' +
                ", original_name='" + original_name + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity='" + popularity + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date=" + release_date +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
