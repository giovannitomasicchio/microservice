package it.giovannitomasicchio.microservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import it.giovannitomasicchio.microservice.dto.AuthorDTO;
import it.giovannitomasicchio.microservice.dto.CommentDTO;
import it.giovannitomasicchio.microservice.dto.PostDTO;
import it.giovannitomasicchio.microservice.dto.TagDTO;
import it.giovannitomasicchio.microservice.events.PostCreatedEvent;
import it.giovannitomasicchio.microservice.jpa.etities.Author;
import it.giovannitomasicchio.microservice.jpa.etities.Comment;
import it.giovannitomasicchio.microservice.jpa.etities.Post;
import it.giovannitomasicchio.microservice.jpa.etities.PostDetail;
import it.giovannitomasicchio.microservice.jpa.etities.PostTag;
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
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	public PostDTO byjpanamedquery(Long id) {
		return post2PostDTO(postJpaRepository.getPostDetailAuthor(id));
	}
	
	public PostDTO bycustomjpa(Long id) {
		return post2PostDTO(postJpaRepository.bycustomjpa(em, id));
	}
	
	public List<PostDTO> byjooq(Long id) {
		return postJooqRepository.get(id);
	}

	@Transactional
	public Post create(PostDTO dto) {
		Post post = new Post()
				.setAuthor(
						new Author()
						.setId(dto.getAuthor().getId()))
				.setData(dto.getData())
				.setPostDetail(
						new PostDetail()
						.setBody(dto.getBody())
						.setTitle(dto.getTitle()));
		
		
		Post savedPost = postJpaRepository.save(post);
		publisher.publishEvent(new PostCreatedEvent(savedPost));
		return savedPost;
	}
	
	@Transactional
	public PostDTO findById(Long id) {
		Optional<Post> post = postJpaRepository.findById(id);
		if(post.isPresent()) {
			post.get().getComments().forEach(c -> c.getAuthor().getName());
		}
		return post2PostDTO(post.get());
	}
	
	private PostDTO post2PostDTO(Post post) {
		if(post == null)
			return null;
		
		PersistenceUnitUtil unitUtil = em.getEntityManagerFactory().getPersistenceUnitUtil();
		
		ArrayList<TagDTO> tags = null;
		if(unitUtil.isLoaded(post.getPostTags())) {
			tags = new ArrayList<TagDTO>();
			for(PostTag pt: post.getPostTags()) {
				tags.add(new TagDTO(pt.getTag().getId(), pt.getTag().getName()));
			}
		}		
		
		ArrayList<CommentDTO> comments = null;
		if(unitUtil.isLoaded(post.getComments())) {		
			comments = new ArrayList<CommentDTO>();
			for(Comment c: post.getComments()) {
				comments.add(new CommentDTO(c.getId(), c.getBody(), c.getData(), new AuthorDTO(c.getAuthor().getId(), c.getAuthor().getName())));
			}
		}
		
		PostDTO postDTO = new PostDTO(
				post.getId(),
				post.getData(),
				!unitUtil.isLoaded(post.getPostDetail()) ? null : post.getPostDetail().getBody(),
				!unitUtil.isLoaded(post.getPostDetail()) ? null : post.getPostDetail().getTitle(),
				!unitUtil.isLoaded(post.getAuthor()) ? null :
				new AuthorDTO(
						post.getAuthor().getId(),
						post.getAuthor().getName()),
				tags,
				comments);
		
		return postDTO;
	}
}
