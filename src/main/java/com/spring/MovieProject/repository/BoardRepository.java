package com.spring.MovieProject.repository;

import com.spring.MovieProject.entity.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardRepository extends CrudRepository<Board, Integer>, PagingAndSortingRepository<Board,Integer> {



}
