package it.giovannitomasicchio.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giovannitomasicchio.microservice.jpa.Comment;
import it.giovannitomasicchio.microservice.jpa.Post;
import it.giovannitomasicchio.microservice.repositories.jpa.CommentJpaRepository;

@Service
public class CommentService {

	@Autowired
	CommentJpaRepository commentJpaRepository;
	
	public List<Comment> findByPost(Post post) {
		return commentJpaRepository.findByPost(post);
	}
}
