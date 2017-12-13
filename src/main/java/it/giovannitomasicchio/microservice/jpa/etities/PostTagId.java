package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class PostTagId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="post_id", insertable=false, updatable=false)
	private Long postId;

	@Column(name="tag_id", insertable=false, updatable=false)
	private Long tagId;
}