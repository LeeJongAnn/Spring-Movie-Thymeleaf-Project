package com.spring.MovieProject.service.user;


import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService{


    private final UserRepository userRepository;

    public userServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(User user) {

        User saveUser = userRepository.save(user);

    }
}
