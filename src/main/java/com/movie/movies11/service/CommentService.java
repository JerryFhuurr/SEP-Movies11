package com.movie.movies11.service;

import com.movie.movies11.models.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> getCommentByMovie(int mId);
    List<Comment> getCommentByUser(int uId);
    String addComment(Comment comment);
    List<Comment> getCommentByMovieUser(int mId, int uId);
    String removeComment(int cId);
    Comment updateComment(Comment comment);
}
