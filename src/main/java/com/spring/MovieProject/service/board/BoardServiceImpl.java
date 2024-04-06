package com.spring.MovieProject.service.board;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements boardService {


    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(Board board, DetailsUser user) {
        board.setUser(user.getDetailsUser());
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }

    @Override
    public List<Board> getBoardList() {
        List<Board> boardList = (List<Board>) boardRepository.findAll();
        return boardList;
    }

    @Override
    public Board updateBoard() {
        return null;
    }

    @Override
    public void deleteBoard() {

    }

    @Override
    public Board getBoard() {
        return null;
    }
}
