package it.giovannitomasicchio.microservice.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.Value;

@Value
public class PostDTO {
	Long id;
	LocalDateTime data;
	String body, title;
	AuthorDTO author;
	ArrayList<TagDTO> tags;
	ArrayList<CommentDTO> comment;
}
