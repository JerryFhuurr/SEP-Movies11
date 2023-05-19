package com.movie.movies11.sqlMapper;

import com.movie.movies11.models.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getCommentByMovie(int mId);
    List<Comment> getCommentByUser(int uId);
    void addComment(Comment comment);
}
