package com.spring.MovieProject.service.reply;


import com.spring.MovieProject.config.DetailsUser;
import com.spring.MovieProject.entity.Reply;
import com.spring.MovieProject.response.ApiResponse;
import com.spring.MovieProject.response.details.ApiResponseDetailsMovie;
import com.spring.MovieProject.service.movieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class replyServiceImpl implements replyService {


    @Override
    public Reply replyCreate(Reply reply, DetailsUser user) {
        return null;
    }

    @Override
    public List<Reply> getReplyList() {
        return null;
    }

    @Override
    public Reply updateReply() {
        return null;
    }

    @Override
    public void deleteReply(Integer id) {

    }

    @Override
    public Reply getReply(Integer id) {
        return null;
    }
}
