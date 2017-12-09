package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the author database table.
 * 
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHOR_ID_GENERATOR", sequenceName="S_AUTHOR", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHOR_ID_GENERATOR")
	private Long id;

	private String name;

//	@JsonBackReference
	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="author")
	private List<Comment> comments;

//	@JsonBackReference
	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="author")
	private List<Post> posts;

	public Author() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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