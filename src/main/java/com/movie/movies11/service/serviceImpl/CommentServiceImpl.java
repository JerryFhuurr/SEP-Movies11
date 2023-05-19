package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.models.Comment;
import com.movie.movies11.models.Rating;
import com.movie.movies11.service.CommentService;
import com.movie.movies11.sqlMapper.CommentMapper;
import com.movie.movies11.sqlMapper.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    RatingMapper ratingMapper;
    @Override
    public List<Comment> getCommentByMovie(int mId) {
        return commentMapper.getCommentByMovie(mId);
    }

    @Override
    public List<Comment> getCommentByUser(int uId) {
        return commentMapper.getCommentByUser(uId);
    }

    @Override
    public void addComment(Comment comment) {
        Rating r = new Rating(comment.getRating(), 0, comment.getMovie());
        ratingMapper.addARating(r);
        commentMapper.addComment(comment);
    }
}
