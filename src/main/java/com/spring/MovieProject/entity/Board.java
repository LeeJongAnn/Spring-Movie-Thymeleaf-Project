package com.spring.MovieProject.entity;


import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Board {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;


    @CreationTimestamp
    private Date creationTime;

    public Board() {
    }

    @Builder
    public Board(Integer id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.creationTime = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
