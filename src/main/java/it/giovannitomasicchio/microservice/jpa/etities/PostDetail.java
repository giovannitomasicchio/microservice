package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="post_detail")
public class PostDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition="NUMERIC")
	private Long id;

	private String body;

	private String title;

	@JsonBackReference
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", foreignKey=@ForeignKey(name="fk_post_detail_post"))
	@MapsId("id")
	private Post post;

	public PostDetail() {
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}