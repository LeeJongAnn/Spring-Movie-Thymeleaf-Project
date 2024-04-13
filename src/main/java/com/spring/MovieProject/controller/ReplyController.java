package com.spring.MovieProject.controller;

import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.exception.CustomException;
import com.spring.MovieProject.exception.ReplyErrorException;
import com.spring.MovieProject.repository.UserRepository;
import com.spring.MovieProject.service.reply.replyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReplyController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private replyServiceImpl replyService;

    @PostMapping("/create-reply/{boardId}/reply")
    public String createReply(Reply reply, @PathVariable(name = "boardId") Integer boardId, @AuthenticationPrincipal DetailsUser user, Model model) {
        try {
            replyService.saveReply(reply, boardId, user);
            model.addAttribute("boardId", boardId);
            return "redirect:/v1/get-board/" + boardId;

        } catch (CustomException exception) {
            throw new ReplyErrorException();
        }
    }
}