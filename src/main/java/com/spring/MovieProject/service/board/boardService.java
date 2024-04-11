package com.spring.MovieProject.service.board;

import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface boardService {

    public Board createBoard(Board board, @AuthenticationPrincipal DetailsUser user);

    public List<Board> getBoardList();

    public Board updateBoard();

    public void deleteBoard(Integer id);

    public Board getBoard(Integer id);




}
