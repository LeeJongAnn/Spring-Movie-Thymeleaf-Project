package com.spring.MovieProject.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 250,nullable = false)
    private String explanation;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    public Role() {
    }

    public Role(Integer id, String name, String explanation) {
        this.id = id;
        this.name = name;
        this.explanation = explanation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
