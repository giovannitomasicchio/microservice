package it.giovannitomasicchio.microservice.dto;

public class AuthorStatsDTO {

	public Long id;
	
	public String name;
	
	public Long postCount;

	public AuthorStatsDTO(Long id, String name, Long postCount) {
		super();
		this.id = id;
		this.name = name;
		this.postCount = postCount;
	}
}
