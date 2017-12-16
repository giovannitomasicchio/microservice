package it.giovannitomasicchio.microservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class TagDTO {
	
	private final Long id;
	
	private final String name;

	@JsonCreator
	public TagDTO(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
		super();
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
