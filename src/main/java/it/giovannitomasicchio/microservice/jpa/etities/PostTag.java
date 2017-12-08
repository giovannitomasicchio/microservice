package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


/**
 * The persistent class for the post_tag database table.
 * 
 */
@Entity
@Table(name="post_tag")
public class PostTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PostTagId id;

	//bi-directional many-to-one association to Post
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("postId")
//	@JsonManagedReference
	private Post post;

	//bi-directional many-to-one association to Tag
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("tagId")
//	@JsonManagedReference
	private Tag tag;

	public PostTag() {
	}

	public PostTagId getId() {
		return this.id;
	}

	public void setId(PostTagId id) {
		this.id = id;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}