package it.giovannitomasicchio.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.giovannitomasicchio.microservice.jpa.etities.Comment;
import it.giovannitomasicchio.microservice.jpa.etities.Post;
import it.giovannitomasicchio.microservice.services.CommentService;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@GetMapping("/")
    public List<Comment> findByPost(@PathVariable Long postId) {
		Post post = new Post();
		post.setId(postId);
		return commentService.findByPost(post);
    }
}
