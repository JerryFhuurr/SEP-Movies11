package com.movie.movies11;

import com.movie.movies11.models.Comment;
import com.movie.movies11.models.Movie;
import com.movie.movies11.models.User;
import com.movie.movies11.service.CommentService;
import com.movie.movies11.sqlMapper.CommentMapper;
import com.movie.movies11.sqlMapper.MovieMapper;
import com.movie.movies11.sqlMapper.RatingMapper;
import com.movie.movies11.sqlMapper.UserMapper;
import com.movie.movies11.util.IdHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class Movies11ApplicationTests {
	@Autowired
	CommentMapper commentMapper;
	@Autowired
	RatingMapper ratingMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	MovieMapper movieMapper;
	@Autowired
	CommentService commentService;

	@Test
	void TestCommentInUser() {
		List<Comment> comments = commentService.getCommentByMovieUser(64465, 2);
		System.out.println(comments.size());
		for (Comment c :
				comments) {
			System.out.println(c.toString());
		}
	}

	@Test
	void TestCommentMatch() {
		List<Comment> comments = commentService.getCommentByMovieUser(64465, 2);
		User user = userMapper.getAUser(2, null);
		Movie movie = movieMapper.getOneMovieById(64465);
		Comment comment = new Comment(6, "test", 5.1f, new Timestamp(System.currentTimeMillis()), user, movie);
		for (Comment c :
				comments) {
			System.out.println(c.getUser().getUserId() + "," + comment.getUser().getUserId());
			System.out.println(c.getMovie().getId() + "," + comment.getMovie().getId());

			System.out.println(c.getUser().getUserId() == comment.getUser().getUserId());
			System.out.println(c.getMovie().getId() == comment.getMovie().getId());
		}
	}

	@Test
	void TestLengthId() {
		String id = "35547";
		String id2 = "699987";
		String id3 = "5547892";
		System.out.println(IdHandler.idExpandTo7(id));
		System.out.println(IdHandler.idExpandTo7(id2));
		System.out.println(IdHandler.idExpandTo7(id3));
	}

}
