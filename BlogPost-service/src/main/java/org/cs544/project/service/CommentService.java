package org.cs544.project.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.cs544.project.Repository.BlogPostRepository;
import org.cs544.project.Repository.CommentRepository;
import org.cs544.project.Repository.UserRepository;
import org.cs544.project.domain.BlogPost;
import org.cs544.project.domain.Comment;
import org.cs544.project.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CommentService {

	@Resource
	private CommentRepository commentRepository;

	@Resource
	private BlogPostRepository blogPostRepository;

	@Resource
	private UserRepository userRepository;

	// gets all commments
	public List<Comment> getComments(int postId) {
		return commentRepository.findCommentById(postId);
	}

	// get comment by id
	public List<Comment> getComment(int id) {
		return commentRepository.findCommentById(id);
	}
	
	//add comment
	public Comment addComment(Comment comment, int postId, int userId) {
		BlogPost tempPost = blogPostRepository.findBlogPostById(postId);
		User user = userRepository.findUserById(userId);
		comment.setCreated(new Date());
		comment.setUpdated(new Date());
		comment.setUser(user);
		tempPost.addComment(comment);
		blogPostRepository.save(tempPost);
		return comment;
	}

	// update Comment

	public Comment updateComment(Comment comment, int commentId) {
        comment.setUpdated(new Date());
		commentRepository.save(comment);
		return comment;
	}

	// deletes post

	public void deleteComment(int id) {
		commentRepository.delete(id);
	}

	

}
