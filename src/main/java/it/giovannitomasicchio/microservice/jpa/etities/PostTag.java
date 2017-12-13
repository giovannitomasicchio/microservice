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

import lombok.Data;

@Entity
@Table(name="post_tag")
@Data
public class PostTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PostTagId id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "post_id", columnDefinition="NUMERIC", foreignKey=@ForeignKey(name="fk_post_tag_post"))
	@MapsId("postId")
	private Post post;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "tag_id", columnDefinition="NUMERIC", foreignKey=@ForeignKey(name="fk_post_tag_tag"))
	@MapsId("tagId")
	private Tag tag;
}