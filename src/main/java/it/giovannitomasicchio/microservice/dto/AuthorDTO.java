package it.giovannitomasicchio.microservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class AuthorDTO {
	
	private final Long id;
	
	private final String name;
	
	@JsonCreator
	public AuthorDTO(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
