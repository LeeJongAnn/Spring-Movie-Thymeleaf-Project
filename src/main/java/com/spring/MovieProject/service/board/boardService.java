package com.spring.MovieProject.service.board;

import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface boardService {

    public Board createBoard(Board board, @AuthenticationPrincipal DetailsUser user);

    public List<Board> getBoardList();

    public Board updateBoard();

    public void deleteBoard(Integer id);

    public Board getBoard(Integer id);

    public Page<Board> pageBoard(int pageNum);




}
