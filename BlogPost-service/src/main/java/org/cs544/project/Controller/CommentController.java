package org.cs544.project.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.cs544.project.domain.Comment;
import org.cs544.project.service.CommentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

	@Resource
	private CommentService commentService;

	@GetMapping(value = "/posts/{postId}/comments")
	public List<Comment> getComments(@PathVariable int postId) {
		return commentService.getComments(postId);
	}

	@GetMapping(value = "/posts/{postId}/comments/{commentId}")
	public Comment getOneComment(@PathVariable int postId, @PathVariable int commentId) {

		return getComments(postId).get(commentId);

	}
	@PostMapping(value = "{userId}/posts/{postId}/comments")
	public Comment addComment(@RequestBody Comment comment, @PathVariable int postId, @PathVariable int userId) {
		
		return	commentService.addComment(comment, postId, userId);
	}
	
	@PutMapping(value = "/{userId}/posts/{postId}/comments/{commentId}")
 	public Comment updateComment(@RequestBody Comment comment,@PathVariable int commentId) {
 		 return	commentService.updateComment(comment, commentId);	
 	}

	@DeleteMapping(value = "/{userId}/posts/{postId}/comments/{commentId}")
	public void deleteComment(@PathVariable int postId, @PathVariable int commentId) {	
		commentService.deleteComment(commentId);
	}
	
	
 	
	
}
