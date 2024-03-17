package com.spring.MovieProject.response;


import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class ApiResponseResult {

    private String adult;
    private String title;
    private String original_name;
    private String overview;
    private String popularity;
    private String poster_path;
    private Date release_date;
    private float vote_average;
    private float vote_count;

}
