package org.cs544.project.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;

import org.cs544.project.domain.BlogPost;
import org.cs544.project.domain.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class BlogPostController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogPostController.class);
	
     private String serviceUrl= "http://localhost:8080/";
	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String homePage(){
		
		return "redirect:/posts";
	}
	
	@GetMapping("/posts")
	public String displayPosts(Model model){
		ResponseEntity<BlogPost[]> posts= restTemplate.getForEntity(serviceUrl+"posts", 
				BlogPost[].class);	
		logger.info("HTTP status: "+posts.getStatusCode().toString());
	   model.addAttribute("posts",posts.getBody());
		return "posts";
	}
	
	@GetMapping("/posts/{postId}") 
	public String displayPost (Model model, @PathVariable int postId){
		//BlogPost post1= restTemplate.getForObject(serviceUrl+"posts/"+postId, BlogPost.class);
	ResponseEntity<BlogPost> post = restTemplate.getForEntity(serviceUrl+"posts/"+postId, BlogPost.class);
    ResponseEntity<Comment[]> comments= restTemplate.getForEntity(serviceUrl+"posts/"+postId+"/comments",Comment[].class);
		System.out.println(post.getBody()); 
		model.addAttribute("post",post.getBody());
		model.addAttribute("comments",comments.getBody());
		return "commentPage";
	}

   @PostMapping(value="{userId}/posts")
	public String addPost(String title, String content, @PathVariable int userId){
	   System.out.println("making a post request");
	   BlogPost post= new BlogPost(title, content);
	   System.out.println(post.getTitle());
	  // System.out.println(userId);
		restTemplate.postForLocation("http://localhost:8080/"+userId+"/posts", post);
		return "redirect:/posts";
	}
   
   //update the post 
   @PostMapping(value="{userId}/posts/{postId}")
   public String updatePost(String title, String content, @PathVariable int userId,@PathVariable int postId){
	   BlogPost post= new BlogPost(title, content);
	   System.out.println("making an update request");
	   System.out.println(post.getContent());
	   restTemplate.put(serviceUrl+userId+"/posts/"+postId, post);
	   return "redirect:/posts"; 
   }
   
   @PostMapping(value = "{userId}/posts/{postId}/comments")
   public String addComment(String content,@PathVariable int postId, @PathVariable int userId) {
	   System.out.println("commenting on a post");
	   Comment comment =new Comment(content);
	   System.out.println(comment.getContent());
	   restTemplate.postForLocation("http://localhost:8080/"+userId+"/posts/"+postId+"/comments", comment);
	   return "redirect:/posts";
   }
   
   @GetMapping("/posts/{postId}/onePost") 
   public String editSinglePost(Model model,@PathVariable int postId){
	   ResponseEntity<BlogPost> post = restTemplate.getForEntity(serviceUrl+"posts/"+postId, BlogPost.class);
	   model.addAttribute("onePost", post.getBody());
	   return "onePost";
   }
   
   @PostMapping("/delete")
   public String deletePost(@RequestParam int postId, @RequestParam int userId){
	   logger.warn("deleting post with postId= "+postId );
	   restTemplate.delete(serviceUrl+userId+"/posts/"+postId);
	   return "redirect:/posts";
   }
   
   @GetMapping("/postForm")
   public String postForm(){   
	   return "postForm";
   }
   @GetMapping("/commentPage")
   public String commentPage(){
	   return "commentPage";
   }
   
   @GetMapping("/registration")
   public String registrationPage(){
	   return "registration";
   }
   
   @GetMapping("/editPost")
   public String editPost(){
	   return "postEdit";
   }
   
   @GetMapping("/aboutUs")
   public String aboutUs(){
	   return "aboutUs";
   }

}
