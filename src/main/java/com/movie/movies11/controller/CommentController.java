package com.movie.movies11.controller;

import com.movie.movies11.models.Comment;
import com.movie.movies11.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comment/")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("get/movie")
    public List<Comment> getCommentByMovie(int mId) {
        return commentService.getCommentByMovie(mId);
    }

    @GetMapping("get/user")
    public List<Comment> getCommentByUser(int uId) {
        return commentService.getCommentByUser(uId);
    }

    @PostMapping("add/one")
    public String addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        return "Comment add:" + comment.toString();
    }
}
