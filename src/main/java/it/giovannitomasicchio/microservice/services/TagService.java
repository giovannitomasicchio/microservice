package it.giovannitomasicchio.microservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.giovannitomasicchio.microservice.repositories.jpa.TagJpaRepository;

@Service
public class TagService {

	@Autowired
	TagJpaRepository tagJpaRepository;
}
