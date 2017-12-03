package it.giovannitomasicchio.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giovannitomasicchio.microservice.dto.AuthorStatsDTO;
import it.giovannitomasicchio.microservice.repositories.jpa.AuthorJpaRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorJpaRepository authorJpaRepository;
	
	public List<AuthorStatsDTO> getAuthorsStats() {
		return authorJpaRepository.getAuthorsStats();
	}
}
