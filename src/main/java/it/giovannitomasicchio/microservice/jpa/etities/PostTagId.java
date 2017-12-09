package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the post_tag database table.
 * 
 */
@Embeddable
public class PostTagId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="post_id", insertable=false, updatable=false)
	private Long postId;

	@Column(name="tag_id", insertable=false, updatable=false)
	private Long tagId;

	public PostTagId() {
	}
	public Long getPostId() {
		return this.postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Long getTagId() {
		return this.tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PostTagId)) {
			return false;
		}
		PostTagId castOther = (PostTagId)other;
		return 
			(this.postId == castOther.postId)
			&& (this.tagId == castOther.tagId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.postId ^ (this.postId >>> 32)));
		hash = hash * prime + ((int) (this.tagId ^ (this.tagId >>> 32)));
		
		return hash;
	}
}