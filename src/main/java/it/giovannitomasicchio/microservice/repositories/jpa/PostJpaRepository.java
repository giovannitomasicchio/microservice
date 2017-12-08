package it.giovannitomasicchio.microservice.repositories.jpa;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import it.giovannitomasicchio.microservice.jpa.etities.Post;

public interface PostJpaRepository  extends JpaRepository<Post, Long> {
	
	/**
	 * Esempio di named query
	 * 
	 * @param id
	 * @return
	 */
	Post getPostDetailAuthor(@Param("id") Long id);
	
	/**
	 * Esempio di metodo custom
	 * 
	 * @return
	 */
	default Post zaza(EntityManager em) {
		return em.find(Post.class, Long.valueOf(1));
	}

}
