package com.spring.MovieProject.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(indexes = {@Index(name = "IDX_USER_EMAIL", columnList = "username,email")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(length = 15,nullable = false)
    private String username;

    @NotNull
    @Column(length = 25,nullable = false, unique = true)
    private String email;


    @NotNull
    @Column(length = 300,nullable = false)
    private String password;

    private boolean enabled;


    @OneToMany
    private List<Role> role = new ArrayList<>();


    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(Integer id, String username, String email, String password,boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }



    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Board> board = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Board> getBoard() {
        return board;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setBoard(List<Board> board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return this.username;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
