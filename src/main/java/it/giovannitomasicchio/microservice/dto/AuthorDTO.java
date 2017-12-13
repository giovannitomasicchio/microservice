package it.giovannitomasicchio.microservice.dto;

public final class AuthorDTO {
	
	private final Long id;
	
	private final String name;
	
	public AuthorDTO(Long id, String name) {
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
