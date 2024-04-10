package com.spring.MovieProject.controller;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.exception.BoardNotFoundException;
import com.spring.MovieProject.exception.CustomException;
import com.spring.MovieProject.service.board.BoardServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BoardController {

    private BoardServiceImpl boardService;

    public BoardController(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }
    /*
     * 게시글과 관련된 컨트롤러로 해당하는 주소로 게시글들이 작성되어 있는 페이지로 이동합니다.
     * */

    @GetMapping("/v1/board")
    public String boardList(Model model,@AuthenticationPrincipal User user) {

        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("board", boardList);
        model.addAttribute("user", user);
        return "Board/boardList";
    }

    /*
    * 24-04-05
    * author: LeeJongAnn
    * description: someone who login user can create post , and finished post redirection in boardList url /v1/board
    * */
    @PostMapping("/v1/createBoard")
    public String boardCreate(Model model, Board board, @AuthenticationPrincipal DetailsUser user) {
        boardService.createBoard(board,user);
        return "redirect:/v1/board";
    }

    /*
     * 24-04-05
     * author: LeeJongAnn
     * description: someone who login user can see post createForm
     * */
    @GetMapping("/v1/boardForm")
    public String boardCreateForm(Model model,Board board) {
        model.addAttribute("board",board);
        return "Board/boardup";
    }


    @GetMapping("/v1/delete-board/{id}")
    public String boardDeleteForm(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        boardService.deleteBoard(id);
        String message = "해당하는 게시글이 삭제되었습니다 : " + id;
        redirectAttributes.addFlashAttribute("result", message);
        return "redirect:/v1/board";
    }
}
