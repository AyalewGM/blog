package org.cs544.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	@Id 
	@GeneratedValue
	private int id;
	private String name;
	private String username;
	private String password;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	List<BlogPost> posts= new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy="user")
	List<Comment> comments= new ArrayList<>();
	
	public User(){}
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public boolean addPost(BlogPost post){
		post.setUser(this);
		return posts.add(post);
	}
	
	public boolean remove(BlogPost post){
		post.setUser(null);
		return posts.remove(post);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<BlogPost> getPosts() {
		return posts;
	}
	public void setPosts(List<BlogPost> posts) {
		this.posts = posts;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
