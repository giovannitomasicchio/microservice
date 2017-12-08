package it.giovannitomasicchio.microservice.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import it.giovannitomasicchio.microservice.jpa.etities.Tag;

public interface TagJpaRepository  extends JpaRepository<Tag, Long> {

}
