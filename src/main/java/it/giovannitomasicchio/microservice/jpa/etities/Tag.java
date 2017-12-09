package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tag")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAG_ID_GENERATOR", sequenceName="S_TAG", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAG_ID_GENERATOR")
	@Column(columnDefinition="NUMERIC")
	private Long id;

	private String name;

	@JsonBackReference
	@OneToMany(mappedBy="tag", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<PostTag> postTags;

	public Tag() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PostTag> getPostTags() {
		return this.postTags;
	}

	public void setPostTags(List<PostTag> postTags) {
		this.postTags = postTags;
	}

	public PostTag addPostTag(PostTag postTag) {
		getPostTags().add(postTag);
		postTag.setTag(this);

		return postTag;
	}

	public PostTag removePostTag(PostTag postTag) {
		getPostTags().remove(postTag);
		postTag.setTag(null);

		return postTag;
	}

}