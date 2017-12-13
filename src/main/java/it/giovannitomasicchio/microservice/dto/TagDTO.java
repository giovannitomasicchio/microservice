package it.giovannitomasicchio.microservice.dto;

public final class TagDTO {
	
	private final Long id;
	
	private final String name;

	public TagDTO(Long id, String name) {
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
