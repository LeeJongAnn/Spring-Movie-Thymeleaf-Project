package com.spring.MovieProject.service.reply;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.repository.BoardRepository;
import com.spring.MovieProject.repository.ReplyRepository;
import com.spring.MovieProject.repository.UserRepository;
import com.spring.MovieProject.response.ApiResponse;
import com.spring.MovieProject.response.details.ApiResponseDetailsMovie;
import com.spring.MovieProject.service.board.BoardServiceImpl;
import com.spring.MovieProject.service.board.boardService;
import com.spring.MovieProject.service.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class replyServiceImpl implements replyService {


    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public List<Reply> replyList() {
        return null;
    }


    @Override
    public Reply saveReply(Reply reply, int boardId, DetailsUser user) {

        Board board = boardRepository.findById(boardId).get();
        reply.setBoard(board);
        String time = changeTimeFormatNow();
        reply.setUser(user.getDetailsUser());
        reply.setCreationTime(time);
        Reply saveReply = replyRepository.save(reply);
        return saveReply;
    }

    @Override
    public void deleteReply(Integer replyId) {

    }

    public String changeTimeFormatNow() {

        String customizerFormat = "yyyy년 MM월 dd일 HH시 mm분 ss초";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(customizerFormat);
        String format = now.format(dateTimeFormatter);

        return format;
    }
}
