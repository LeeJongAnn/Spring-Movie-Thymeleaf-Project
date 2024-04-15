package com.spring.MovieProject.controller;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.service.board.BoardServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Deprecated(forRemoval = true)
    @GetMapping("/v1/board")
    String boardList(Model model, @AuthenticationPrincipal User user) {

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
        boardService.createBoard(board, user);
        return "redirect:/v1/board-page/1";
    }

    /*
     * 24-04-05
     * author: LeeJongAnn
     * description: someone who login user can see post createForm
     * */
    @GetMapping("/v1/boardForm")
    public String boardCreateForm(Model model, Board board) {
        model.addAttribute("board", board);
        return "Board/boardup";
    }


    @GetMapping("/v1/delete-board/{id}")
    public String boardDeleteForm(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        boardService.deleteBoard(id);
        String message = "해당하는 게시글이 삭제되었습니다 : " + id;
        redirectAttributes.addFlashAttribute("result", message);
        return "redirect:/v1/board-page/1";
    }


    @GetMapping("/v1/get-board/{boardId}")
    public String boardDetails(@PathVariable(name = "boardId") Integer id, Model model, Reply reply) {
        Board board = boardService.getBoard(id);
        List<Reply> replyList = board.getReplyList();
        model.addAttribute("board", board);
        model.addAttribute("id", board.getId());
        model.addAttribute("reply", reply);
        model.addAttribute("replyList", replyList);
        return "Board/boardConfirm";
    }

    @GetMapping("/v1/boardForm/{boardId}")
    public String boardUpdate(@PathVariable(name = "boardId") Integer boardId, Model model) {
        Board board = boardService.getBoard(boardId);
        model.addAttribute("board", board);
        return "Board/boardup";
    }


    @GetMapping("/v1/board-page/{pageNum}")
    public String pageBoard(@PathVariable("pageNum") int pageNum, Model model,@AuthenticationPrincipal User user) {

        Page<Board> boards = boardService.pageBoard(pageNum);
        List<Board> content = boards.getContent();
        model.addAttribute("board", content);
        model.addAttribute("totalPages", boards.getTotalPages());
        model.addAttribute("user", user);
        model.addAttribute("pageNum", pageNum);
        return "Board/boardList";

    }
}
