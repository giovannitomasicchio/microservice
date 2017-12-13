package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="post_detail")
public class PostDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition="NUMERIC")
	private Long id;

	private String body;

	private String title;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", foreignKey=@ForeignKey(name="fk_post_detail_post"))
	@MapsId
	private Post post;

	public Long getId() {
		return id;
	}

	public PostDetail setId(Long id) {
		this.id = id;
		return this;
	}

	public String getBody() {
		return body;
	}

	public PostDetail setBody(String body) {
		this.body = body;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public PostDetail setTitle(String title) {
		this.title = title;
		return this;
	}

	public Post getPost() {
		return post;
	}

	public PostDetail setPost(Post post) {
		this.post = post;
		return this;
	}
}