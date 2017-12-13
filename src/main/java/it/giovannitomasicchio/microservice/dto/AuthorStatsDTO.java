package it.giovannitomasicchio.microservice.dto;

public final class AuthorStatsDTO {

	private final Long id;
	
	private final String name;
	
	private final Long postCount;

	public AuthorStatsDTO(Long id, String name, Long postCount) {
		this.id = id;
		this.name = name;
		this.postCount = postCount;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getPostCount() {
		return postCount;
	}
}
