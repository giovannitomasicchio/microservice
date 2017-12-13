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

import lombok.Data;

@Entity
@Table(name="post_detail")
@Data
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
}