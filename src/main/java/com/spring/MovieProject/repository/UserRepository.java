package com.spring.MovieProject.repository;

import com.spring.MovieProject.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
