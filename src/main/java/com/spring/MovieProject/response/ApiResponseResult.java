package com.spring.MovieProject.response;


import lombok.Data;

import java.util.Date;

@Data
public class ApiResponseResult {

    private String adult;
    private String original_name;
    private String overview;
    private String popularity;
    private String poster_path;
    private Date first_air_date;
    private String vote_average;
    private String vote_count;


}
