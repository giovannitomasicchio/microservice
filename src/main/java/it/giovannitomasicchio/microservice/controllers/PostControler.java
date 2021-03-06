package it.giovannitomasicchio.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.giovannitomasicchio.microservice.dto.PostDTO;
import it.giovannitomasicchio.microservice.jpa.etities.Post;
import it.giovannitomasicchio.microservice.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostControler {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/bycustomjpa/")
    public PostDTO bycustomjpa(@RequestParam("id") Long id) {
        return postService.bycustomjpa(id);
    }
	
	@GetMapping("/findById/{id}")
    public PostDTO findById(@PathVariable Long id) {
		 return postService.findById(id);
    }
	
	@GetMapping("/byjpanamedquery/{id}")
    public PostDTO byjpanamedquery(@PathVariable Long id) {
		 return postService.byjpanamedquery(id);
    }
	
	@GetMapping("/byjooq/{id}")
    public List<PostDTO> get(@PathVariable Long id) {
		 return postService.byjooq(id);
    }	
	
	@PostMapping("/")
	public void create(@RequestBody PostDTO dto) {
		Post savedPost = postService.create(dto);
		System.out.println("Post ID = " + savedPost.getId());
	}
}
