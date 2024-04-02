package com.spring.MovieProject.service.board;

import com.spring.MovieProject.entity.Board;

import java.util.List;

public interface boardService {

    public Board createBoard(Board board);

    public List<Board> getBoardList();

    public Board updateBoard();

    public void deleteBoard();

    public Board getBoard();



}
