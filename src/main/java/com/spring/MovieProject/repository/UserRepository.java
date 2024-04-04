package com.spring.MovieProject.repository;

import com.spring.MovieProject.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

     Optional<User> findByEmail(String email);

}
