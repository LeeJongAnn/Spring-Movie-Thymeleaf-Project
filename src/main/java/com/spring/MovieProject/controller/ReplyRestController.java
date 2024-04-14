//package com.spring.MovieProject.controller;
//
//
//import com.spring.MovieProject.service.reply.replyServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ReplyRestController {
//
//
//    @Autowired
//    private replyServiceImpl replyService;
//
//    @GetMapping("/v1/delete-reply/{id}")
//    public ResponseEntity<?> replyDelete(@PathVariable(name = "id") Integer id) {
//
//        replyService.deleteReply(id);
//        return ResponseEntity.ok().build();
//    }
//}
