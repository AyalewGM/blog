package org.cs544.project.Repository;

import java.util.List;

import org.cs544.project.domain.BlogPost;
import org.cs544.project.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface  CommentRepository extends JpaRepository<Comment,Integer>{
	@Query("select b.comments from BlogPost b where b.id = ?1 ")
	public List<Comment> findCommentById(int id);

}
