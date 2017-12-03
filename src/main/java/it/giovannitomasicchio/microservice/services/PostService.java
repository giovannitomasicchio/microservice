package it.giovannitomasicchio.microservice.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giovannitomasicchio.microservice.dto.PostDTO;
import it.giovannitomasicchio.microservice.jpa.Post;
import it.giovannitomasicchio.microservice.repositories.jooq.PostJooqRepository;
import it.giovannitomasicchio.microservice.repositories.jpa.PostJpaRepository;

@Service
public class PostService {

	@Autowired
	EntityManager em;
	
	@Autowired
	PostJpaRepository postJpaRepository;
	
	@Autowired
	PostJooqRepository postJooqRepository;
	
	public Post byjpanamedquery(Long id) {
		return postJpaRepository.getPostDetailAuthor(id);
	}
	
	public Post bycustomjpa() {
		return postJpaRepository.zaza(em);
	}
	
	public List<PostDTO> byjooq(Long id) {
		return postJooqRepository.get(id);
	}

	@Transactional
	public void create(Post post) {
		postJpaRepository.save(post);
	}
}
