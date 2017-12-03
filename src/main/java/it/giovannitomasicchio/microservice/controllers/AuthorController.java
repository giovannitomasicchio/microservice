package it.giovannitomasicchio.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.giovannitomasicchio.microservice.dto.AuthorStatsDTO;
import it.giovannitomasicchio.microservice.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("/")
	public List<AuthorStatsDTO> getAuthorsStats() {
		return authorService.getAuthorsStats();
	}
}
