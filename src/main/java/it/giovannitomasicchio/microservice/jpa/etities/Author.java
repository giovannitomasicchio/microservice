package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHOR_ID_GENERATOR", sequenceName="S_AUTHOR", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHOR_ID_GENERATOR")
	@Column(columnDefinition="NUMERIC")
	private Long id;

	private String name;

	@OneToMany(mappedBy="author")
	private List<Comment> comments;

	@OneToMany(mappedBy="author")
	private List<Post> posts;

	public Long getId() {
		return id;
	}

	public Author setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Author setName(String name) {
		this.name = name;
		return this;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public Author setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}
	
	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAuthor(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAuthor(null);

		return comment;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public Author setPosts(List<Post> posts) {
		this.posts = posts;
		return this;
	}
	
	public Post addPost(Post post) {
		getPosts().add(post);
		post.setAuthor(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setAuthor(null);

		return post;
	}
}