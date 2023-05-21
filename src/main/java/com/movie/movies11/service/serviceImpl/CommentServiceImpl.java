package com.movie.movies11.service.serviceImpl;

import com.movie.movies11.exception.DbExceptionClass;
import com.movie.movies11.exception.ErrorCode;
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
    public String addComment(Comment comment) {
        int count = 0;
        List<Comment> commentFromUser = getCommentByMovieUser(comment.getMovie().getId(), comment.getUser().getUserId());
        for (Comment c : commentFromUser) {
            if (c.getUser().getUserId() == comment.getUser().getUserId()
            && c.getMovie().getId() == comment.getMovie().getId()) {
                count++;
            }
        }
        if (count > 0) {
            String msg = "Comment already existed";
            throw new DbExceptionClass(ErrorCode.Comment.COMMENT_ALREADY_EXISTED, msg);
        } else {
            if (comment.getRating() > 0 && comment.getRating() < 10) {
                Rating r = new Rating(comment.getRating(), 0, comment.getMovie());
                ratingMapper.addARating(r);
                commentMapper.addComment(comment);
                return "Add comment:" + comment.toString();
            } else {
                throw new DbExceptionClass(ErrorCode.Rating.RATING_NUMBER_OVER_RANGE,
                        "Please enter valid rating");
            }

        }
    }

    @Override
    public List<Comment> getCommentByMovieUser(int mId, int uId) {
        return commentMapper.getCommentByMovieUser(mId, uId);
    }

    @Override
    public String removeComment(int cId) {
        commentMapper.removeComment(cId);
        return "Comment:" + cId + " has been removed";
    }

    @Override
    public Comment updateComment(Comment comment) {
        Comment c = commentMapper.getCommentByMovieUser(comment.getMovie().getId(), comment.getUser().getUserId()).get(0);
        c.setCommentContext(comment.getCommentContext());
        if (comment.getRating() != c.getRating()) {
            c.setRating(comment.getRating());
            Rating rating = new Rating(comment.getRating(), 0, comment.getMovie());
            ratingMapper.removeARating(rating);
            ratingMapper.addARating(rating);
        }
        commentMapper.updateComment(c);
        return c;
    }
}
