package com.spring.MovieProject.config;

import com.spring.MovieProject.entity.User;
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


        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("해당하는 유저가 존재하지 않습니다."));
        return new DetailsUser(user);

    }
}
