package com.spring.MovieProject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {



    @GetMapping("/v1/login-page")
    public String loginPage(){
        return "Login/login";
    }

}
