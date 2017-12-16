package it.giovannitomasicchio.microservice.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class PostDTO {
	
	private final Long id;
	
	private final LocalDateTime data;
	
	private final String title;
	
	private final String body;
	
	private final AuthorDTO author;
	
	private final ArrayList<TagDTO> tags;
	
	private final ArrayList<CommentDTO> comment;
	
	@JsonCreator
	public PostDTO(
			@JsonProperty("id") Long id,
			@JsonProperty("data") LocalDateTime data,
			@JsonProperty("title") String title,
			@JsonProperty("body") String body,
			@JsonProperty("author") AuthorDTO author,
			@JsonProperty("tags") ArrayList<TagDTO> tags,
			@JsonProperty("comment") ArrayList<CommentDTO> comment) {
		this.id = id;
		this.data = data;
		this.title = title;
		this.body = body;
		this.author = author;
		this.tags = tags;
		this.comment = comment;
	}
	
	public PostDTO(Long id, LocalDateTime data, Long authorId, String authorName, String body, String title) {
		this.id = id;
		this.data = data;
		this.title = title;
		this.body = body;
		this.author = new AuthorDTO(authorId, authorName);
		this.tags = null;
		this.comment = null;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public ArrayList<TagDTO> getTags() {
		return tags;
	}

	public ArrayList<CommentDTO> getComment() {
		return comment;
	}
}
