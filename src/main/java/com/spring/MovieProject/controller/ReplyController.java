package com.spring.MovieProject.controller;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Board;
import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.service.reply.replyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReplyController {

    @Autowired
    private replyService replyService;

    @PostMapping("/v1/reply-board")
    public String boardCreate(Model model, Reply reply, @AuthenticationPrincipal DetailsUser user) {
        replyService.replyCreate(reply, user);
        return "redirect:/v1/board";
    }

}
