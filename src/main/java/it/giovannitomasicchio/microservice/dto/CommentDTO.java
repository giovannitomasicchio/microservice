package it.giovannitomasicchio.microservice.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class CommentDTO {
	
	private final Long id;
	
	private final String body;
	
	private final LocalDateTime data;
	
	private final AuthorDTO author;

	@JsonCreator
	public CommentDTO(@JsonProperty("id") Long id, @JsonProperty("body") String body, @JsonProperty("data") LocalDateTime data, @JsonProperty("author") AuthorDTO author) {
		this.id = id;
		this.body = body;
		this.data = data;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public String getBody() {
		return body;
	}

	public LocalDateTime getData() {
		return data;
	}

	public AuthorDTO getAuthor() {
		return author;
	}
}
