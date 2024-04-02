package com.spring.MovieProject.service.board;

import com.spring.MovieProject.entity.Board;

import java.util.List;

public interface boardService {

    public Board createBoard();

    public List<Board> getBoardList();

    public Board updateBoard();

    public void deleteBoard();

    public Board getBoard();



}
