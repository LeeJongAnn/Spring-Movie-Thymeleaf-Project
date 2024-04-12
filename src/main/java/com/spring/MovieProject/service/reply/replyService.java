package com.spring.MovieProject.service.reply;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.entity.Reply;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

public interface replyService {


    public Reply replyCreate(Reply reply, @AuthenticationPrincipal DetailsUser user);

    public List<Reply> getReplyList();

    public Reply updateReply();

    public void deleteReply(Integer id);

    public Reply getReply(Integer id);


}
