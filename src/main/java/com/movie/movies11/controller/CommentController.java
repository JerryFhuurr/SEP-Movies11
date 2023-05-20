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
        return commentService.addComment(comment);
    }

    @DeleteMapping("remove/one")
    public String removeAComment(int cId) {
        return commentService.removeComment(cId);
    }

    @PutMapping("update/one")
    public String updateComment(@RequestBody Comment comment) {
        commentService.updateComment(comment);
        return commentService.getCommentByMovieUser(comment.getMovie().getId(), comment.getUser().getUserId()).get(0).toString();
    }
}
