package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PostTagId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="post_id", insertable=false, updatable=false)
	private Long postId;

	@Column(name="tag_id", insertable=false, updatable=false)
	private Long tagId;

	public Long getPostId() {
		return postId;
	}

	public PostTagId setPostId(Long postId) {
		this.postId = postId;
		return this;
	}

	public Long getTagId() {
		return tagId;
	}

	public PostTagId setTagId(Long tagId) {
		this.tagId = tagId;
		return this;
	}
}