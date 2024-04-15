package com.spring.MovieProject.config;

import com.spring.MovieProject.entity.Role;
import com.spring.MovieProject.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;



@Getter
public class DetailsUser implements UserDetails {

    private User user;

    public DetailsUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Role> role = user.getRole();
        for (Role roles : role) {
            authorities.add(new SimpleGrantedAuthority(roles.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return this.getUsername();
    }

    public User getDetailsUser() {
        return user;
    }

    public void setDetailsUser(User user) {
        this.user = user;
    }
}
