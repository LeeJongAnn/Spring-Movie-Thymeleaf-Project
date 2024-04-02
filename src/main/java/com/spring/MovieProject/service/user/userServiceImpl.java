package com.spring.MovieProject.service.user;


import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.UserNotFoundException;
import com.spring.MovieProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<User> listUsers() {
        List<User> usersList = (List<User>) userRepository.findAll();

        return usersList;
    }

    @Override
    public User getUser(Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("해당하는 유저가 존재하지 않습니다. ID : " + id));

        return user;


    }


    @Override
    public User updateUser(Integer id) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {

        Optional<User> findUser = userRepository.findById(id);
        if (findUser.isEmpty()) {
            throw new UserNotFoundException("해당하는 유저가 존재하지 않습니다.");
        } else {
            userRepository.deleteById(id);
        }

    }
}
