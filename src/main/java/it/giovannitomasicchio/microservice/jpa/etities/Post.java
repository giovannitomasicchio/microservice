package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POST_ID_GENERATOR", sequenceName="S_POST", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POST_ID_GENERATOR")
	@Column(columnDefinition="NUMERIC")
	private Long id;

	private LocalDateTime data;

	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "author_id", foreignKey=@ForeignKey(name="fk_post_author"))
	private Author author;

	@OneToOne(mappedBy="post", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private PostDetail postDetail;

	@OneToMany(mappedBy="post", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PostTag> postTags;

	public Long getId() {
		return id;
	}

	public Post setId(Long id) {
		this.id = id;
		return this;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Post setData(LocalDateTime data) {
		this.data = data;
		return this;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public Post setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
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
		return author;
	}

	public Post setAuthor(Author author) {
		this.author = author;
		return this;
	}

	public PostDetail getPostDetail() {
		return postDetail;
	}

	public Post setPostDetail(PostDetail postDetail) {
		this.postDetail = postDetail;
		postDetail.setPost(this);
		return this;
	}

	public List<PostTag> getPostTags() {
		return postTags;
	}

	public Post setPostTags(List<PostTag> postTags) {
		this.postTags = postTags;
		return this;
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