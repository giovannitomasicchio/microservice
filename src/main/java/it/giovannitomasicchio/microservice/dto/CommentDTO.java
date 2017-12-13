package it.giovannitomasicchio.microservice.dto;

import java.time.LocalDateTime;

import lombok.Value;

@Value
public class CommentDTO {
	Long id;
	String body;
	LocalDateTime data;
	AuthorDTO author;
}
