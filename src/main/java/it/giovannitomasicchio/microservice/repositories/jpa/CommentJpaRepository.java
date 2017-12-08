package it.giovannitomasicchio.microservice.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import it.giovannitomasicchio.microservice.jpa.etities.Comment;
import it.giovannitomasicchio.microservice.jpa.etities.Post;

public interface CommentJpaRepository  extends JpaRepository<Comment, Long> {

	@EntityGraph(attributePaths = { "post", "post.postDetail", "author" })
	List<Comment> findByPost(Post post);
}
