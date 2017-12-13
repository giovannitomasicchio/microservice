package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMENT_ID_GENERATOR", sequenceName="S_COMMENT", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMENT_ID_GENERATOR")
	@Column(columnDefinition="NUMERIC")
	private Long id;

	private String body;

	private LocalDateTime data;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "author_id", foreignKey=@ForeignKey(name="fk_comment_author"))
	private Author author;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "post_id", foreignKey=@ForeignKey(name="fk_comment_post"))
	private Post post;

	public Long getId() {
		return id;
	}

	public Comment setId(Long id) {
		this.id = id;
		return this;
	}

	public String getBody() {
		return body;
	}

	public Comment setBody(String body) {
		this.body = body;
		return this;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Comment setData(LocalDateTime data) {
		this.data = data;
		return this;
	}

	public Author getAuthor() {
		return author;
	}

	public Comment setAuthor(Author author) {
		this.author = author;
		return this;
	}

	public Post getPost() {
		return post;
	}

	public Comment setPost(Post post) {
		this.post = post;
		return this;
	}
}