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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "post")
@Data
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
	
	@PreUpdate
    @PrePersist
    public void setBidirectionalReferences() {
		if(this.postDetail != null) {
			this.postDetail.setPost(this);
		}
	}
}