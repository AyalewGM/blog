package org.cs544.project.Repository;

import java.util.List;

import org.cs544.project.domain.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BlogPostRepository extends JpaRepository<BlogPost,Integer> {
	BlogPost findBlogPostById(int postId);
	List<BlogPost> findBlogPostByUserId(int userId);
	
	@Modifying
	@Query("update BlogPost p set p.title = ?1, p.content = ?2 where p.id = ?3")
	void setBlogPostInfoById(String title, String content, Integer postId);
	
}
