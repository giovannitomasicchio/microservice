package it.giovannitomasicchio.microservice.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.giovannitomasicchio.microservice.dto.AuthorStatsDTO;
import it.giovannitomasicchio.microservice.jpa.etities.Author;

public interface AuthorJpaRepository  extends JpaRepository<Author, Long> {

	List<AuthorStatsDTO> getAuthorsStats();
}
