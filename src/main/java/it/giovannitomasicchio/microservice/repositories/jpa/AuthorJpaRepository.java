package it.giovannitomasicchio.microservice.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import it.giovannitomasicchio.microservice.jpa.Author;

public interface AuthorJpaRepository  extends JpaRepository<Author, Long> {

}
