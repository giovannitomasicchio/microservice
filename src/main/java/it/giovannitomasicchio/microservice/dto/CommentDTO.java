package it.giovannitomasicchio.microservice.dto;

import java.time.LocalDateTime;

public final class CommentDTO {
	
	private final Long id;
	
	private final String body;
	
	private final LocalDateTime data;
	
	private final AuthorDTO author;

	public CommentDTO(Long id, String body, LocalDateTime data, AuthorDTO author) {
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
