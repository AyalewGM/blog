package org.cs544.project.Controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import javax.annotation.Resource;

import org.cs544.project.domain.BlogPost;
import org.cs544.project.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogPostController {
	@Resource
	private BlogPostService postService;
	
	public static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);
	
	@GetMapping(value="/posts")
	public List<BlogPost>getAllPosts(){	
	return postService.getPosts();
	}
	@PostMapping(value="{userId}/posts",consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public BlogPost addPost(@RequestBody BlogPost post, @PathVariable int userId){
		System.out.println(post);
		return postService.addPost(post,userId);
	}  
	
	@GetMapping(value="/posts/{postId}")
	public BlogPost getPost(@PathVariable int postId){
		
		return postService.getPost(postId);
	}

	@PutMapping(value ="{userId}/posts/{postId}")
	public BlogPost updatePost(@PathVariable int postId,@RequestBody BlogPost post){
		return postService.updatePost(post, postId);
	}
	
	@DeleteMapping(value="{userId}/posts/{postId}")
	public void deletePost(@PathVariable int postId){
		postService.deletePost(postId);
	}
	
	@GetMapping("/editPost")
	public List<BlogPost> getPostByUserId(@RequestParam int userId){
		
		return postService.getPostByUserId(userId);
	}

}
