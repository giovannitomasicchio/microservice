package it.giovannitomasicchio.microservice.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the post database table.
 * 
 */
@Entity
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POST_ID_GENERATOR", sequenceName="S_POST", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POST_ID_GENERATOR")
	private Long id;

	private LocalDateTime data;

//	@JsonBackReference
	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	//bi-directional many-to-one association to Author
	@ManyToOne(fetch=FetchType.LAZY)
	private Author author;

	@JsonManagedReference
	@OneToOne(mappedBy="post", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private PostDetail postDetail;

//	@JsonBackReference
	@OneToMany(mappedBy="post")
	private List<PostTag> postTags;

	public Post() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return this.data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setPost(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setPost(null);

		return comment;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public PostDetail getPostDetail() {
		return this.postDetail;
	}

	public void setPostDetail(PostDetail postDetail) {
		this.postDetail = postDetail;
		postDetail.setPost(this); // IMPORTANTE !!!
	}

	public List<PostTag> getPostTags() {
		return this.postTags;
	}

	public void setPostTags(List<PostTag> postTags) {
		this.postTags = postTags;
	}

	public PostTag addPostTag(PostTag postTag) {
		getPostTags().add(postTag);
		postTag.setPost(this);

		return postTag;
	}

	public PostTag removePostTag(PostTag postTag) {
		getPostTags().remove(postTag);
		postTag.setPost(null);

		return postTag;
	}

}