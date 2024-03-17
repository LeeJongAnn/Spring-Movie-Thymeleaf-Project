package com.spring.MovieProject.response;


import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
public class ApiResponseResult {

    private String adult;
    private String original_name;
    private String overview;
    private String popularity;
    private String poster_path;
    private Date first_air_date;
    private String vote_average;
    private String vote_count;

    @Override
    public String toString() {
        return "ApiResponseResult{" +
                "adult='" + adult + '\'' +
                ", original_name='" + original_name + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity='" + popularity + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", first_air_date=" + first_air_date +
                ", vote_average='" + vote_average + '\'' +
                ", vote_count='" + vote_count + '\'' +
                '}';
    }
}
