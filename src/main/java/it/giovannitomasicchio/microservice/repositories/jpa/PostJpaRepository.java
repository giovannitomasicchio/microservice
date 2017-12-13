package it.giovannitomasicchio.microservice.repositories.jpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
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
	
	@EntityGraph(attributePaths = { "postDetail", "author",  "postTags", "postTags.tag"})
	Optional<Post> findById(Long id);
	
	/**
	 * Esempio di metodo custom
	 * @param id 
	 * 
	 * @return
	 */
	@Transactional // per lasciare aperta la sessione di Hibernate dopo la find
	default Post bycustomjpa(EntityManager em, Long id) {
		javax.persistence.EntityGraph<Post> eg = em.createEntityGraph(Post.class);
		eg.addAttributeNodes("author", "postDetail");
		eg.addSubgraph("postTags").addAttributeNodes("tag");
		
		Map<String, Object> hints = new HashMap<>();
		hints.put("javax.persistence.fetchgraph", eg);
		
		Post p = em.find(Post.class, id, hints);
		if(p != null) {
			p.getComments().forEach(c -> c.getAuthor().getName());
		}
		
		return p;
	}

}
