package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="post_tag")
public class PostTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PostTagId id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "post_id", columnDefinition="NUMERIC", foreignKey=@ForeignKey(name="fk_post_tag_post"))
	@MapsId("postId")
	@JsonManagedReference
	private Post post;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "tag_id", columnDefinition="NUMERIC", foreignKey=@ForeignKey(name="fk_post_tag_tag"))
	@MapsId("tagId")
	@JsonManagedReference
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