package com.spring.MovieProject.service.user;


import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.CustomException;
import com.spring.MovieProject.exception.SignUpIsDuplicatedException;
import com.spring.MovieProject.exception.UserNotFoundException;
import com.spring.MovieProject.repository.RoleRepository;
import com.spring.MovieProject.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public userServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(User user) {

        User dbUser = userRepository.findByEmail(user.getEmail());
        if (dbUser != null) {
            throw new SignUpIsDuplicatedException();
        }
        String password = user.getPassword();
        String encode = passwordEncoder.encode(password);
        user.setPassword(encode);
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
