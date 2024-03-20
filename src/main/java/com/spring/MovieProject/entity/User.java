package com.spring.MovieProject.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(length = 15,nullable = false)
    private String username;

    @NotNull
    @Column(length = 25,nullable = false)
    private String email;


    @Embedded
    private Address address;

    @NotNull
    @Column(length = 300,nullable = false)
    private String password;



    public User() {
    }

    public User(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
