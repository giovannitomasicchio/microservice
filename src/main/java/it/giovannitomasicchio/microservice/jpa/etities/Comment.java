package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDateTime;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMENT_ID_GENERATOR", sequenceName="S_COMMENT", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMENT_ID_GENERATOR")
	private Long id;

	private String body;

	private LocalDateTime data;

	@JsonManagedReference
	//bi-directional many-to-one association to Author
	@ManyToOne(fetch=FetchType.LAZY)
	private Author author;

	@JsonManagedReference
	//bi-directional many-to-one association to Post
	@ManyToOne(fetch=FetchType.LAZY)
	private Post post;

	public Comment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getData() {
		return this.data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}