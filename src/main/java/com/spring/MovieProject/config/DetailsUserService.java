package com.spring.MovieProject.config;

import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.UserNotFoundException;
import com.spring.MovieProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DetailsUserService implements UserDetailsService {



    private UserRepository userRepository;

    @Autowired
    public DetailsUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) {


        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return new DetailsUser(user);

    }
}
