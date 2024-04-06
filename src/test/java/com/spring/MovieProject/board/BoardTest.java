package com.spring.MovieProject.board;


import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.UserNotFoundException;
import com.spring.MovieProject.repository.BoardRepository;
import com.spring.MovieProject.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class BoardTest {


    private BoardRepository boardRepository;

    private UserRepository userRepository;

    @Autowired
    public BoardTest(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @Test
    @DisplayName("게시글 임시로 생성")
    public void boardEntityTest() throws UserNotFoundException {
//
//        User user = userRepository.findById(8).orElseThrow(()-> new UserNotFoundException("해당 유저가 존재하지 않습니다."));
//
//        Board board = new Board().title("윤동주의 서시")
//                .content("한국 현대 시의 거장으로 평가받는 윤동주의 대표작 중 하나로, 그의 시적 세계와 철학을 잘 보여주는 작품입니다.")
//                .user(user)
//                .build();
//
//        boardRepository.save(board);
    }


    @Test
    @DisplayName("LocalDateTime 객체 원하는 형태로 변경하기")
    public void testTime() {
        String customizerFormat = "yyyy년 MM월 dd일 HH시 mm분 ss초";

        /*
        * author: LeeJongAnn
        * description: Changes the class of LocalDateTime at the current time to the pattern of the cutomizer.
        * */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(customizerFormat);
        String format = now.format(dateTimeFormatter);
        System.out.println(now);
        System.out.println(format);

    }

}
