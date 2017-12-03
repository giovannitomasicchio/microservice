package it.giovannitomasicchio.microservice.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAG_ID_GENERATOR", sequenceName="S_TAG", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAG_ID_GENERATOR")
	private Long id;

	private String name;

//	@JsonBackReference
	//bi-directional many-to-one association to PostTag
	@OneToMany(mappedBy="tag")
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