package com.spring.MovieProject.response.details;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class ApiResponseDetailsMovie {

    private String adult;

    private Integer id;
    private String title;

    private List<genres> genres;

    private String overview;

    private String popularity;

    private String poster_path;

    private String release_date;
    private String video;
    private float vote_average;
    private float vote_count;


}
