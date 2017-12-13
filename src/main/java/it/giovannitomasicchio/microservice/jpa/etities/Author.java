package it.giovannitomasicchio.microservice.jpa.etities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHOR_ID_GENERATOR", sequenceName="S_AUTHOR", allocationSize = 50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHOR_ID_GENERATOR")
	@Column(columnDefinition="NUMERIC")
	private Long id;

	private String name;

	@OneToMany(mappedBy="author")
	private List<Comment> comments;

	@OneToMany(mappedBy="author")
	private List<Post> posts;
}