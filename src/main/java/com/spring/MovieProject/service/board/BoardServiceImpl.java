package com.spring.MovieProject.service.board;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.BoardNotFoundException;
import com.spring.MovieProject.exception.CustomException;
import com.spring.MovieProject.exception.UserNotFoundException;
import com.spring.MovieProject.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements boardService {



    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(Board board, DetailsUser user) {

        board.setCreationTime(changeTimeFormatNow());
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
    public void deleteBoard(Integer id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Board getBoard(Integer id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new BoardNotFoundException());
        return board;
    }

    /*
     * author: LeeJongAnn
     * description: Changes the class of LocalDateTime at the current time to the pattern of the cutomizer.
     * */
    public String changeTimeFormatNow() {

        String customizerFormat = "yyyy년 MM월 dd일 HH시 mm분 ss초";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(customizerFormat);
        String format = now.format(dateTimeFormatter);

        return format;
    }
}
