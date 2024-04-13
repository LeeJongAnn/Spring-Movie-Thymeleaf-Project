package com.spring.MovieProject.service.reply;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.entity.Reply;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

public interface replyService {


    List<Reply> replyList();

    Reply saveReply(Reply reply,int boardId,@AuthenticationPrincipal DetailsUser user);

    void deleteReply(Integer replyId);


}
