package org.cs544.project.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.cs544.project.Repository.BlogPostRepository;
import org.cs544.project.Repository.UserRepository;
import org.cs544.project.domain.BlogPost;
import org.cs544.project.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BlogPostService {
	
	@Resource
	private BlogPostRepository postRepository;
	@Resource
	private UserRepository userRepository;

	//gets all posts
	public List<BlogPost> getPosts(){
		System.out.println("returning posts");
		return postRepository.findAll();
	}
	
	//gets one post by id
	public BlogPost getPost(int id){
		System.out.println("returning A single post");
		return postRepository.findBlogPostById(id);
	}
	
	//adds the post
	public BlogPost addPost(BlogPost post, int userId){
		System.out.println("Saving a post");
		
        User user= (User)userRepository.findUserById(userId);
        post.setUser(user);
        post.setCreated(new Date());
        post.setUpdated(new Date());
        System.out.println(post);
		postRepository.save(post);
		return post;
	}
	
	//updates post
	public BlogPost updatePost(BlogPost post, int postId){
		postRepository.setBlogPostInfoById(post.getTitle(), post.getContent(), postId);
		BlogPost post2 =(BlogPost) postRepository.findBlogPostById(postId);
		return post2;
	}
	
	//deletes post
	public void deletePost(int id){
		System.out.println("deleting a post");
		postRepository.delete(id);
	}
	
	public List<BlogPost> getPostByUserId(int userId){
	  return postRepository.findBlogPostByUserId(userId);
	}
	
}
